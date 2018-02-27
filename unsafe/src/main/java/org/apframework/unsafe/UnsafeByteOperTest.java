package org.apframework.unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

public class UnsafeByteOperTest {

    private static int byteArrayBaseOffset;

    public static void main(String[] args)
            throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // 通过反射得到theUnsafe对应的Field对象
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        // 设置该Field为可访问
        theUnsafe.setAccessible(true);
        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        Unsafe UNSAFE = (Unsafe) theUnsafe.get(null);
        System.out.println(UNSAFE);

        byte[] data = new byte[10];
        System.out.println(Arrays.toString(data));
        //arrayBaseOffset方法是一个本地方法，可以获取数组第一个元素的偏移地址
        byteArrayBaseOffset = UNSAFE.arrayBaseOffset(byte[].class);

        System.out.println(byteArrayBaseOffset);
        //putByte直接修改内存数据
        UNSAFE.putByte(data, byteArrayBaseOffset, (byte) 1);
        UNSAFE.putByte(data, byteArrayBaseOffset + 5, (byte) 5);
        System.out.println(Arrays.toString(data));
    }
}
