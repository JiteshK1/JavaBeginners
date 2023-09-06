package com.jitesh.threads;

import static com.jitesh.threads.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+"Main thread");
        AnotherThread anotherThread = new AnotherThread();
        anotherThread.start();
        Thread runnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_GREEN+"Anonymus Implemented Class running run()");
            try {
                anotherThread.join();
                System.out.println(ANSI_GREEN+"Another Thread Terminated so running again");
            }catch (InterruptedException e){
                System.out.println("Cant run because interrupted");
            }
            }
        });
        runnableThread.start();


        new Thread(() -> System.out.println(ANSI_RED+"From Anonymous Thread")).start();
        System.out.println(ANSI_PURPLE+"Again from Main thread");
    }
}
