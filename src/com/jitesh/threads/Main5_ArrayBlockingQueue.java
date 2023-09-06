package com.jitesh.threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static com.jitesh.threads.Main4.EOF;

public class Main5_ArrayBlockingQueue {
    static final String EOF="EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        MyProducers producer=new MyProducers(buffer,ThreadColor.ANSI_GREEN);
        MyConsumers consumer1=new MyConsumers(buffer,ThreadColor.ANSI_PURPLE);
        MyConsumers consumer2=new MyConsumers(buffer,ThreadColor.ANSI_CYAN);
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
             executorService.shutdown();
    }
}
class MyProducers implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducers(ArrayBlockingQueue<String> buffer, String color ) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5"};

        for(String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                try {
                    buffer.put(num);
                } catch (InterruptedException e){

                }

                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e){

        }
    }
}
class MyConsumers implements  Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumers(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {


        while(true) {
                try {
                    synchronized (buffer) {
                        if (buffer.isEmpty()) {
                            continue;
                        }
                        if (buffer.peek().equals(EOF)) {
                            System.out.println(color + "Exiting");
                            break;
                        } else {
                            System.out.println(color + "Removed " + buffer.take());
                        }
                    }} catch (InterruptedException e){

                }

        }
    }
}
