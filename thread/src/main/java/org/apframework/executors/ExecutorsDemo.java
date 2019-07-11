package org.apframework.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FROM 《Java中线程池，你真的会用吗》 https://blog.csdn.net/hollis_chuang/article/details/83743723
 *
 * @Author: Shoukai Huang
 * @Date: 2019/7/11 14:43
 */
public class ExecutorsDemo {

    private static ExecutorService executor = Executors.newFixedThreadPool(15);

    // FIXME run with : -Xmx8m -Xms8m
    public static void main(String[] args) {
        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                executor.execute(new SubThread());
            }
        } catch (Error error) {
            // java.lang.OutOfMemoryError: GC overhead limit exceeded
            error.printStackTrace();
        }
    }
}

class SubThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}
