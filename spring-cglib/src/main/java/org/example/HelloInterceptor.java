package org.example;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class HelloInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.printf("method:%s args:%s%n", method, Arrays.toString(args));
        return proxy.invokeSuper(object, args);
    }
}
