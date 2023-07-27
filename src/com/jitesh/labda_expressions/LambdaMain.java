package com.jitesh.labda_expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class LambdaMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Mohammad","Jakir","Brono","Xtrmis"));

        System.out.println(list);
        System.out.println("-".repeat(35));
        for (String s:
              list) {
            System.out.println(s);
        }
        System.out.println("-".repeat(35));
           list.forEach(string -> System.out.println(string)) ;
        System.out.println("-".repeat(35));
        list.forEach( (var string) -> System.out.println(string)) ;
        System.out.println("-".repeat(35));
   list.replaceAll(s->s.charAt(0)+" - "+ s.toUpperCase());
        System.out.println(list);
        System.out.println("-".repeat(35));
      String[] empty = new String[10];
      Arrays.setAll(empty,i -> " "+ (i+1)+ "." );
        System.out.println(Arrays.toString(empty));
        System.out.println("-".repeat(35));
        Arrays.setAll(empty,i -> " "+ (i+1)+ "." +
                switch(i){
                 case 0 -> "one";
                    case 1 -> "Two";
                    default -> "";
                }
                );
        System.out.println(Arrays.toString(empty));
        System.out.println("-".repeat(35));
        String[] names={"raju","pinku","ramu","Sasu","pandu"};
        String[] randomList = randomInt(50,names,()-> new Random().nextInt(0,names.length));
        System.out.println(Arrays.toString(randomList));


        var c1 = calculator((a,b)-> a+b,5,33);
        var c2 = calculator((a,b)->a/b,2,4);
        var c3 = calculator(( a,  b)-> a.toUpperCase()+" "+b.toUpperCase(),"asb","gft");

        list.removeIf(s->s.equalsIgnoreCase("jakir"));
        System.out.println(list);
          var coords= Arrays.asList(new Double[]{11.12,2.21},new Double[]{1331.121,2.21},new Double[]{117.12,72.1167},new Double[]{141.12,52.211});

          for(var cor: coords){
              System.out.println(Arrays.toString(cor));
          }
          var firstPoint=coords.get(0);
          BiConsumer<Double,Double> p1 = ((lat,log)-> System.out.printf("[lat:%.3f lon:%,3f]%n",lat,log));
        System.out.println("-".repeat(35));
          processPoint(firstPoint[0],firstPoint[1],p1);
        System.out.println("-".repeat(35));
        coords.forEach(s->processPoint(s[0],s[1],p1));
    }



    public static  <T> T calculator(Operation<T> operation,T value1,T value2){
             T result = operation.operator(value1,value2);
        System.out.println("Operation resulted in : "+result);
return result;
    }
    public static  <T> T calculator1(BinaryOperator<T> operation, T value1, T value2){
        T result = operation.apply(value1,value2);
        System.out.println("Operation resulted in : "+result);
        return result;
    }
    public static <T> void  processPoint(T value1, T value2, BiConsumer<T,T> consumer){
        consumer.accept(value1,value2);
    }
    public static String[] randomInt(int count, String[] string, Supplier<Integer> s ){
        String[] values = new String[count];
        for (int i = 0; i < count ; i++) {
            values[i]=string[s.get()];
        }
return values;
    }
}

