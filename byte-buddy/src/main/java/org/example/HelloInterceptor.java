package org.example;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class HelloInterceptor {
    @RuntimeType
    public Object intercept(@Origin Method method,
                            @AllArguments Object[] allArguments,
                            @SuperCall Callable<?> callable) {
        System.out.printf("method:%s args:%s%n", method, Arrays.toString(allArguments));
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
