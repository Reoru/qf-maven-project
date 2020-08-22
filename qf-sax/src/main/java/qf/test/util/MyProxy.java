package qf.test.util;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import qf.test.mapper.UserMapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/21 0021 下午 20:39
 */
public class MyProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("doing callback...");
        return null;
    }
}
