package org.apframework.spi.serializer;

import org.apframework.spi.exception.ObjectSerializerException;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/6/3 19:38
 */
public interface ObjectSerializer {

    /**
     * 序列化对象
     *
     * @param obj 需要序更列化的对象
     * @return byte []
     * @throws ObjectSerializerException 异常
     */
    byte[] serialize(Object obj) throws ObjectSerializerException;


    /**
     * 反序列化对象
     *
     * @param param 需要反序列化的byte []
     * @param clazz 序列化后对应的java class
     * @param <T>   泛型
     * @return <T>
     * @throws ObjectSerializerException 异常
     */
    <T> T deSerialize(byte[] param, Class<T> clazz) throws ObjectSerializerException;

    String getSchemeName();
}
