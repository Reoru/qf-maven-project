package com.qf.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 20:21
 */
public class BeanUtil {
    private Map<String,Method> getMethodsMap = new HashMap<>();
    private Map<String,Method> setMethodsMap = new HashMap<>();
    private BeanUtil(){}

    public static Map<String,Method> getMethods(Class<?> clazz){
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();

        }
        return null;
    }
}
