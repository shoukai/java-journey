package org.apframework.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

class User {
    private String name = "test";
    private long id = 1;
    private int age = 2;
    private double height = 1.72;

    @Override
    public String toString() {
        return name + "," + id + "," + age + "," + height;
    }
}

/**
 * from http://www.cnblogs.com/duanxz
 */
public class UnsafeModifyFieldTest {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
            IllegalAccessException {
        // 通过反射得到theUnsafe对应的Field对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // 设置该Field为可访问
        field.setAccessible(true);
        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        Unsafe unsafe = (Unsafe) field.get(null);

        User user = new User();
        System.out.println(user); // 打印test,1,2,1.72

        Class userClass = user.getClass();
        Field name = userClass.getDeclaredField("name");
        Field id = userClass.getDeclaredField("id");
        Field age = userClass.getDeclaredField("age");
        Field height = userClass.getDeclaredField("height");
        // 直接往内存地址写数据
        unsafe.putObject(user, unsafe.objectFieldOffset(name), "midified-name");
        unsafe.putLong(user, unsafe.objectFieldOffset(id), 100l);
        unsafe.putInt(user, unsafe.objectFieldOffset(age), 101);
        unsafe.putDouble(user, unsafe.objectFieldOffset(height), 100.1);

        System.out.println(user);// 打印midified-name,100,101,100.1

    }
}
