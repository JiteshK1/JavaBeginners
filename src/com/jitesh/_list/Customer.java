package com.jitesh._list;

import java.util.ArrayList;

public class Customer {
    private  String name;
    private ArrayList<Double> transactions;

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public  void addTransactions(double transaction){
        transactions.add(transaction);
    }

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        this.transactions.add(initialTransaction);
    }
}
