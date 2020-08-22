package nio;

import java.io.IOException;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        socket.getOutputStream().write("Hello World!".getBytes());
        socket.close();
    }
}