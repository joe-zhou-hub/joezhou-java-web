package com.joezhou.start;

/**
 * @author JoeZhou
 */
public class HelloWorld {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("HelloWorld!!!!");
        }).start();
    }
}
