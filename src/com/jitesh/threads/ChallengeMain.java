package com.jitesh.threads;

public class ChallengeMain {
    public static void main(String[] args) {

BankAccount bankAccount= new BankAccount("12345-678",100.0);

Thread thread1 = new Thread(new Runnable() {
    @Override
    public void run() {
        bankAccount.deposit(300.0);
        bankAccount.withdraw(50.00);

    }
});
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    bankAccount.deposit(203.0);
                    bankAccount.withdraw(100.00);

            }
        });
    thread1.start();
    thread2.start();
    }
}
