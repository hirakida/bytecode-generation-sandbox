package org.example;

public class HelloService {
    public String greet() {
        return "Hello!";
    }

    public String greet(String name) {
        return "Hello from " + name;
    }
}
