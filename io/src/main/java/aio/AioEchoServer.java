package aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Future;

public class AioEchoServer {

    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        // 监听accept事件
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Object attachment) {
                try {
                    System.out.println("accept new conn: " + socketChannel.getRemoteAddress());
                    // 再次监听accept事件
                    serverSocketChannel.accept(null, this);

                    // 消息的处理
                    while (true) {
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        // 将数据读入到buffer中
                        Future<Integer> future = socketChannel.read(buffer);
                        if (future.get() > 0) {
                            buffer.flip();
                            byte[] bytes = new byte[buffer.remaining()];
                            // 将数据读入到byte数组中
                            buffer.get(bytes);

                            String content = new String(bytes, StandardCharsets.UTF_8);
                            // 换行符会当成另一条消息传过来
                            if (content.equals("\r\n")) {
                                continue;
                            }
                            if (content.equalsIgnoreCase("quit")) {
                                socketChannel.close();
                                break;
                            } else {
                                System.out.println("receive msg: " + content);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("failed");
            }
        });

        // 阻塞住主线程
        System.in.read();
    }
}
