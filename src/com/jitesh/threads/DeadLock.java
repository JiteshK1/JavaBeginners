package com.jitesh.threads;



public class DeadLock {
    public static Object lock1=new Object();
    public static Object lock2=new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

static class  Thread1 extends Thread{
    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("Thread 1: Has lock1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
            System.out.println("Thread 1: is waiting for lock 2");
            synchronized (lock2) {
                System.out.println("Thread 1: Has lock1 and lock2");
            }
            System.out.println("Thread 1: Released lock2");
        }
        System.out.println("Thread 1: Released lock1. Exiting...");

    }
}
static class Thread2 extends Thread {
    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("Thread 2: Has lock1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
            System.out.println("Thread 2: is waiting for lock 2");
            synchronized (lock2) {
                System.out.println("Thread 2: Has lock1 and lock2");
            }
            System.out.println("Thread 2: Released lock2");
        }
        System.out.println("Thread 2: Released lock1. Exiting...");

    }
}
}
