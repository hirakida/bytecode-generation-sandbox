package org.example;

import org.springframework.cglib.proxy.Enhancer;

public class App {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloService.class);
        enhancer.setCallback(new HelloInterceptor());

        HelloService helloService = (HelloService) enhancer.create();
        System.out.println(helloService.greet());
        System.out.println(helloService.greet("cglib"));
    }
}
