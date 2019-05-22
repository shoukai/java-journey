package org.apframework.reflect.type;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/5/9 15:15
 */
public class TypeMain {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        Method method = TypeMain.class.getMethod("testType", List.class, List.class, List.class, List.class, List.class, Map.class);
        Type[] types = method.getGenericParameterTypes();

        for (Type type : types) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            System.out.println("Method GenericParameterTypes ,当前 type: " + type);
            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type type2 = actualTypeArguments[i];
                System.out.println(i + " 类型【" + type2 + "】 类型接口【" + type2.getClass().getInterfaces()[0].getSimpleName() + "】");
            }
        }
    }

    public <T> void testType(List<String> a1, List<ArrayList<String>> a2, List<T> a3, List<? extends Number> a4, List<ArrayList<String>[]> a5, Map<String, Integer> a6) {
        System.out.println(new Object[]{a1, a2, a3, a4, a5, a6});
    }
}
