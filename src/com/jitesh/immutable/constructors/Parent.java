package com.jitesh.immutable.constructors;

public class Parent {
    static {
        System.out.println("Parent Static Initializer");
    }
    private final String name;
    private final String dob;

    protected final int siblings;

    {
        System.out.println("Parent Initializer");
    }
    public Parent(String name, String dob, int siblings) {
        this.name = name;
        this.dob = dob;
        this.siblings = siblings;
        System.out.println("In Parent Constructor");

    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +", dob='" + dob+ '\'';
    }
}
