package com.jitesh._list;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public String getName() {
        return name;
    }


    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public boolean newCustomer(String cname,double transaction){
        if (findCustomer(cname)!=null){
            return false;
        }
         customers.add(new Customer(cname,transaction));
        return true;

    }
    public boolean addCustomerTransaction(String cname,double transaction){
        if (findCustomer(cname)!=null){
            findCustomer(cname).addTransactions(transaction);
            return true;
        }

        return false;
    }

    public Customer findCustomer(String cname){
        for (Customer c: customers){
            if (c.getName().compareTo(cname)==0){
                return c;
            }
        }
        return null;

    }
}
