package com.jitesh.labda_expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MethodChallenge {
static Random random = new Random();
    public static void main(String[] args) {
        String[] arr = {"BasKr", "praKsh", "BOb", "lvmBBodhr", "HariKurt"};

        List<String> list = Arrays.asList(arr);

         List<UnaryOperator<String>> listUnaray= new ArrayList<>(List.of(
               String::toLowerCase,
               s-> s+" "+seedChar('a','b')
         ));
         applyChanges(arr,listUnaray);
        System.out.println(Arrays.toString(arr));
        list.replaceAll(String::toUpperCase);
        System.out.println(list);


    }

    public static char seedChar(char a, char b){
        return (char) random.nextInt((int) a,(int) b+1);
    }

    public static void applyChanges(String[] arr , List<UnaryOperator<String>> functions){
        List<String> list = Arrays.asList(arr);
        for(var function: functions){
              list.replaceAll(s->s.transform(function));
        }
    }
public static <T>void  seedArray(String[] arr,UnaryOperator<T> function){
 Arrays.setAll(arr,s-> arr[s].transform(String::toLowerCase));
}
}
