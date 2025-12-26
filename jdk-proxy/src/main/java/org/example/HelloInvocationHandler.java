package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class HelloInvocationHandler implements InvocationHandler {
    private final HelloService target;

    public HelloInvocationHandler(HelloService helloService) {
        target = helloService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("method:%s, args:%s%n", method, Arrays.toString(args));
        return method.invoke(target, args);
    }
}
