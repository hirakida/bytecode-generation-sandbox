package org.example;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class App {
    public static void main(String[] args) throws Exception {
        ClassReader reader = new ClassReader(HelloService.class.getName());
        ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        reader.accept(new HelloClassVisitor(writer), ClassReader.EXPAND_FRAMES);

        Class<?> clazz = new MyClassLoader().defineClass(HelloService.class.getName(), writer.toByteArray());
        Object helloService = clazz.getDeclaredConstructor().newInstance();
        System.out.println(clazz.getDeclaredMethod("greet").invoke(helloService));
        System.out.println(clazz.getDeclaredMethod("greet", String.class).invoke(helloService, "asm"));
    }

    private static class MyClassLoader extends ClassLoader {
        Class<?> defineClass(String name, byte[] bytes) throws ClassFormatError {
            return defineClass(name, bytes, 0, bytes.length);
        }
    }
}
