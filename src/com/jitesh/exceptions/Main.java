package com.jitesh.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x= 90;
        int y = 0;
        System.out.println(divideLBYL(x,y));
        System.out.println(divideEAFP(x,y));
        int z= getIntEAFP();
        System.out.println("The number is "+z);

    }

    public static int getIntLBYL(){
        System.out.print("Enter the number ");
        Scanner scanner=new Scanner(System.in);
        String input=scanner.next();
        boolean isValid=true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))){
                isValid=false;
                break;
            }
        }
        if (isValid){
          return   Integer.parseInt(input);
        }
        return 0;
    }
    public static int getIntEAFP(){
        System.out.print("Enter the number ");
        Scanner scanner=new Scanner(System.in);
        try {
            return scanner.nextInt();
        }catch (InputMismatchException e){
            return 0;
        }
    }

    public static  int divideLBYL(int x,int y){
        if (y!=0){
            return x/y;
        }

        return 0;
    }
    public static  int divideEAFP(int x,int y) {
    try {
        return x/y;
    }catch (ArithmeticException e){
        return 0;
    }

    }
}
