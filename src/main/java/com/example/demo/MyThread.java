package com.example.demo;

public class MyThread extends Thread{
    MyThread() {
        System.out.println("Hello");
    }
    public void run() {
        System.out.println("Test12");
    }
}
