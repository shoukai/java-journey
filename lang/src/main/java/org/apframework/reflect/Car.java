package org.apframework.reflect;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/5/9 11:00
 */
public class Car implements IVehicle {

    @Override
    public void run() {
        System.out.println("Car is running");
    }
}
