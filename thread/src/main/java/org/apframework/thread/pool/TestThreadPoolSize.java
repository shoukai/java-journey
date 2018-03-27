package org.apframework.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolSize {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2, 10, 0L,
                TimeUnit.MILLISECONDS,
                // new ArrayBlockingQueue<>(5)
                new LinkedBlockingQueue()
        );
        executorService.execute(new TaskA());
        System.out.println(executorService.getActiveCount());
        System.out.println(executorService.getCorePoolSize());

        Thread.sleep(1000);
        for (int i = 0; i < 9; i++) {
            executorService.execute(new TaskB());
        }
        System.out.println(executorService.getActiveCount());
        System.out.println(executorService.getCorePoolSize());
    }


    public static class TaskA implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class TaskB implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
