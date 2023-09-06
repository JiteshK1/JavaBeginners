package com.jitesh.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
        private String accountNumber;
   Lock reentrantLock ;
    public BankAccount(String accountNumber,double initialBalance ) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.reentrantLock= new ReentrantLock();
    }
    public  void deposit(double amount){
        boolean status=false;
try {
    if (reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS))
        try {
            balance+=amount;
            status=true;

        }finally {
            reentrantLock.unlock();
        }}
catch (InterruptedException e){

}
        System.out.printf("Transaction status "+status);
    }
    public  void withdraw(double amount){
        boolean status=false;
        try {

            if (reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS))

                try {
                    balance -= amount;
                    status=true;
                } finally {
                    reentrantLock.unlock();
                }
        }catch (InterruptedException e){

        }
        System.out.printf("Transaction status "+status);
    }
    public String getAccountNumber(){return accountNumber;}
    public void printAccountNumber(){
        System.out.println("Account Number "+accountNumber);
    }
}
