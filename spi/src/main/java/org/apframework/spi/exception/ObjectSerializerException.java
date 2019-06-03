package org.apframework.spi.exception;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/6/3 19:38
 */
public class ObjectSerializerException extends Exception {

    private static final long serialVersionUID = -948934144333391208L;

    public ObjectSerializerException() {
    }

    public ObjectSerializerException(String message) {
        super(message);
    }

    public ObjectSerializerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectSerializerException(Throwable cause) {
        super(cause);
    }
}