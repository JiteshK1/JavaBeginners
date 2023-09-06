package com.jitesh.threads;

import static com.jitesh.threads.ThreadColor.ANSI_BLUE;

public class AnotherThread  extends  Thread{
    @Override
    public void run() {
        System.out.println(ANSI_BLUE+"From Another Thread");
 try {
     Thread.sleep(3000);
 }catch (InterruptedException e){
     System.out.println(ANSI_BLUE+"Interrupted by Another Thread");
 }
        System.out.println(ANSI_BLUE+"woke after 3 sec");
    }
}
