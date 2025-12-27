package org.example;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class App {
    public static void main(String[] args) {
        Class<? extends HelloService> dynamicType = new ByteBuddy()
                .subclass(HelloService.class)
                .method(ElementMatchers.named("greet"))
                .intercept(MethodDelegation.to(new HelloInterceptor()))
                .make()
                .load(App.class.getClassLoader())
                .getLoaded();
        try {
            HelloService helloService = dynamicType.getDeclaredConstructor().newInstance();
            System.out.println(helloService.greet());
            System.out.println(helloService.greet("Byte Buddy"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
