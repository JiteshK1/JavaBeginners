package com.jitesh.labda_expressions;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

class PlainOld{
    private   static int getId=1;
private int id;

    public PlainOld() {
        id = PlainOld.getId++;
        System.out.println("Creating a PlainOld Object: id = " + id);
    }
}

public class MethodMain {
    public static void main(String[] args) {


            calculator(Integer::sum,5,2);
            calculator(Double::sum,5.1,3.2);

        Supplier<PlainOld>pojo= PlainOld::new;
        System.out.println(pojo.get());
        PlainOld[] pojo1 = seedArray(PlainOld::new,10);

          calculator((s1,s2)->s1.concat(s2),"hello","world");
          calculator(String::concat,"hello","world");
          String result = "hello";
           result = result.transform(String::toUpperCase);
        System.out.println(result);

        Function<String,Boolean> r1 = String::isEmpty;
        System.out.println(r1.apply("hello"));

        BinaryOperator<String> b1=String::concat;

        System.out.println(b1.apply("Ram ","Sita"));
    }

    public static <T> void calculator(BinaryOperator<T> operator,T value1,T value2 ){
       T result= operator.apply(value1,value2);
        System.out.println("Result of Operation is: "+result);
        }

        public static PlainOld[] seedArray(Supplier<PlainOld> supplier,int count){
        PlainOld[] value = new PlainOld[count];
            Arrays.setAll(value,i-> supplier.get());
    return value;
    }
}
