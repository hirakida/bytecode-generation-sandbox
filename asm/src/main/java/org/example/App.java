package org.example;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.io.UncheckedIOException;

public class App {
    public static void main(String[] args) {
        ClassReader reader;
        try {
            reader = new ClassReader(HelloService.class.getName());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        reader.accept(new HelloClassVisitor(writer), ClassReader.EXPAND_FRAMES);

        Class<?> clazz = new MyClassLoader().defineClass(HelloService.class.getName(), writer.toByteArray());
        try {
            Object helloService = clazz.getDeclaredConstructor().newInstance();
            System.out.println(clazz.getDeclaredMethod("greet").invoke(helloService));
            System.out.println(clazz.getDeclaredMethod("greet", String.class).invoke(helloService, "asm"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static class MyClassLoader extends ClassLoader {
        Class<?> defineClass(String name, byte[] bytes) throws ClassFormatError {
            return defineClass(name, bytes, 0, bytes.length);
        }
    }
}
