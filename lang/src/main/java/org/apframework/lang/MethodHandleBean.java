package org.apframework.lang;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/5/8 20:45
 */
public class MethodHandleBean {

    public MethodHandleBean() {
    }

    public MethodHandleBean(Integer value) {
        this.value = value;
    }

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MethodHandle{" +
                "value=" + value +
                '}' + " -> MethodHandle";
    }

}
