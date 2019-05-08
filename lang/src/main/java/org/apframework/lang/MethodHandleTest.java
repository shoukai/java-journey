package org.apframework.lang;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/5/8 20:45
 */
public class MethodHandleTest {

    public static void main(String[] args) throws Throwable {
        MethodHandleBean handle = new MethodHandleBean(101);

        MethodHandle methodHandle = MethodHandles.lookup() // 获取当前类
                .findVirtual(
                        MethodHandleBean.class,
                        "toString",
                        MethodType.methodType(String.class));

        // do like this:
        System.out.println((String) methodHandle.invokeExact(handle));

        // or like this:
        MethodHandle bandToMethodHandle = methodHandle.bindTo(handle);
        System.out.println((String) bandToMethodHandle.invokeWithArguments());

        // 得到当前Class的不同表示方法，最后一个最好。一般我们在静态上下文用SLF4J得到logger用。
        System.out.println(MethodHandleTest.class);
        System.out.println((new MethodHandleTest()).getClass());
        System.out.println(MethodHandles.lookup().lookupClass()); // like getClass()
    }

}
