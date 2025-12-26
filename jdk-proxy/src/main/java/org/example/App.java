package org.example;

import java.lang.reflect.Proxy;

public class App {
    public static void main(String[] args) {
        HelloService helloService =
                (HelloService) Proxy.newProxyInstance(App.class.getClassLoader(),
                        HelloServiceImpl.class.getInterfaces(),
                        new HelloInvocationHandler(new HelloServiceImpl()));
        System.out.println(helloService.greet());
        System.out.println(helloService.greet("JDK Proxy"));
    }
}
