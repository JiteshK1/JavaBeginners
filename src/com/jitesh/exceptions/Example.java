package com.jitesh.exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
       try{
           int result = divide();
           System.out.println(result);

       }catch (ArithmeticException | NoSuchElementException e){
           System.out.println(e.toString());
           System.out.println("Cant operate");
       }
    }

    public static int divide() {
        int x, y;
//        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
//        } catch (NoSuchElementException e) {
//            throw new ArithmeticException("No input data");
//        } catch (ArithmeticException e) {
//            throw new ArithmeticException("no cannot be divided by 0");
//        }
    }

    public static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number: ");
        while (true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                // go round again.  Read past the end of line in the input first
                s.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9 ");
            }
        }
    }
}
