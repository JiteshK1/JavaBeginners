package com.jitesh.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String[] name = {"Raze","Chamber","Yoru","Omen","Killjoy"};
        list.addAll(Arrays.asList(name));
         list.forEach(System.out::println);
            list.add("Martin");
        System.out.println("Martin is in the list " +list.contains("Martin"));

            list.removeIf(s-> s.charAt(0) == 'M');
        System.out.println("Martin is in the list " +list.contains("Martin"));

          List<Card> deck=  Card.getStandardDeck();
               Card.printDeck(deck);
    }
}
