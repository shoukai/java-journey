package org.apframework.reflect;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/5/9 11:03
 */
public class Main {
    public static void main(String[] args) {

        IVehicle car = new Car();
        VehicleProxy proxy = new VehicleProxy(car);

        IVehicle proxyObj = proxy.create();
        proxyObj.run();
    }
}
