package com.qf.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/22 0022 上午 9:34
 */
public class BeanUtils<T, V> {
    private BeanUtils() {
    }

    public static <T, V> T copy(V origin, Class<T> target) {
        // 父类的所有字段
        Field[] pFields = origin.getClass().getDeclaredFields();



        T t = null;
        // 目标对象的对应字段setter方法
        try {
            t = target.newInstance();
            for (Field pField : pFields) {
                pField.setAccessible(true);
                Method setMethod = target.getMethod("set" + (pField.getName().substring(0, 1).toUpperCase() + pField.getName().substring(1)), pField.getType());
                Object o = pField.get(origin);
                setMethod.invoke(t, o);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }
}
