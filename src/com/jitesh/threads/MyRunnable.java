package com.jitesh.threads;

import static com.jitesh.threads.ThreadColor.ANSI_GREEN;

public class MyRunnable implements java.lang.Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_GREEN+"HEllo from runnable method run()");

    }
}
