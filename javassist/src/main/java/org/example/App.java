package org.example;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class App {
    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("org.example.HelloService");

        CtMethod ctMethod1 = ctClass.getDeclaredMethod("greet");
        ctMethod1.insertBefore("System.out.println(\"Before\");");
        ctMethod1.insertAfter("System.out.println(\"After\");");
        CtClass[] ctClasses = {classPool.get(String.class.getName())};
        CtMethod ctMethod2 = ctClass.getDeclaredMethod("greet", ctClasses);
        ctMethod2.insertBefore("System.out.println(\"Before name:%s\".formatted(new String[]{name}));");

        Class<?> clazz = ctClass.toClass();
        HelloService helloService = (HelloService) clazz.getDeclaredConstructor().newInstance();
        helloService.greet();
        helloService.greet("javassist");
    }
}
