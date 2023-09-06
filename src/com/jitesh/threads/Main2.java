package com.jitesh.threads;

public class Main2 {
    public static void main(String[] args) {
        CountDown countDown = new CountDown();

        ThreadCountDown threadCountDown1=new ThreadCountDown(countDown);
        threadCountDown1.setName("Thread 1");
        ThreadCountDown threadCountDown2=new ThreadCountDown(countDown);
        threadCountDown2.setName("Thread 2");
    threadCountDown1.start();
    threadCountDown2.start();
    }

}

class CountDown{
//    public synchronized void doCountDown(){

    public  void doCountDown(){
String color;
switch (Thread.currentThread().getName()){
    case "Thread 1" :{
        color=ThreadColor.ANSI_CYAN;
        break;
    }
    case "Thread 2":{
        color=ThreadColor.ANSI_PURPLE;
    }
    default:
        color=ThreadColor.ANSI_GREEN;
}
synchronized (this) {
    for (int i = 10; i > 0; i--) {
        System.out.println(color + Thread.currentThread().getName() + " : " + i);
    }
}
    }


}
class ThreadCountDown extends  Thread{
    CountDown threadCountDown;
    public ThreadCountDown(CountDown countDown) {
        threadCountDown=countDown;
    }
    @Override
    public void run() {
        threadCountDown.doCountDown();
    }
}
