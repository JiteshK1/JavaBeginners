package com.jitesh.immutable.constructors;

public record Person(String name,String dob) {
    public Person {
        dob=dob.replace('-','/');
    }


    public Person(Person p) {
        this(p.name(), p.dob());
    }
}

