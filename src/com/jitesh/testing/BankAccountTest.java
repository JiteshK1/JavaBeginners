package com.jitesh.testing;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Running before any Test");
        System.out.println("Current count "+ count++);
    }

    BankAccount bankAccount;
    static  int count;
    @BeforeEach
    void setUp() {
        bankAccount=new BankAccount("romas","asd",1000.0,BankAccount.CHECKING);
        System.out.println("running test");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
       bankAccount.deposit(200.0,true);
        assertEquals(1200.00, bankAccount.getBalance(), 0);

    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            double balance = bankAccount.withdraw(600.00, false);

            assertEquals(400.00, bankAccount.getBalance(), 0);

        });
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        assertEquals(1000.00, bankAccount.getBalance(), 0);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Running after the tests cases");
        System.out.println("Current count "+count++);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Count "+ count++);
    }

}