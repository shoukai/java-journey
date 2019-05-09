package org.apframework.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/5/9 11:01
 */
public class VehicleProxy {

    private IVehicle vehicle;

    public VehicleProxy(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public IVehicle create() {
        final Class<?>[] interfaces = new Class[]{IVehicle.class};
        final VehicleInvocationHandler handler = new VehicleInvocationHandler(vehicle);
        return (IVehicle) Proxy.newProxyInstance(IVehicle.class.getClassLoader(), interfaces, handler);
    }

    public class VehicleInvocationHandler implements InvocationHandler {

        private final IVehicle vehicle;

        public VehicleInvocationHandler(IVehicle vehicle) {
            this.vehicle = vehicle;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("--before running...");
            Object ret = method.invoke(vehicle, args);
            System.out.println("--after running...");
            return ret;
        }
    }
}
