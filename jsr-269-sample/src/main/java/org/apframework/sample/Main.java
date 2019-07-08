package org.apframework.sample;

import org.apframework.jsr.pluggable.ApTimer;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/7/8 14:53
 */
public class Main {

    @ApTimer({3, 6})
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello0");
        Thread.sleep(300);
        System.out.println("Hello2");
        System.out.println("Hello3");
        System.out.println("Hello4");
        Thread.sleep(400);
        System.out.println("Hello6");
        System.out.println("Hello7");
        Thread.sleep(200);
        System.out.println("Hello9");
    }

}
