package com.example.thread;

public class MainApplication {
    public static void main(String[] args) {
        String mainThread = Thread.currentThread().getName();
        System.out.println(mainThread);
    }
}
