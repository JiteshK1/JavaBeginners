package com.jitesh.collection.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3= String.join("l","He","lo");
        String s4 ="Hel".concat("lo");
       String s5 ="hello";

        List<String> hellos =  Arrays.asList(s1,s2,s3,s4,s5);
        hellos.forEach(s-> System.out.println(s+" "+s.hashCode()));

        Set<String> mySet = new HashSet<>(hellos);
        System.out.println(mySet);
        for (String setValue : mySet) {
            System.out.print(setValue + ": ");
            for (int i = 0; i < hellos.size(); i++) {
                  if (setValue == hellos.get(i)){
                      System.out.print( i+", "  );
                  }
        }
            System.out.println(" ");

        }

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards =
                Arrays.asList(aceHearts, kingClubs, queenSpades);

        cards.forEach(s-> System.out.println(s + " "+s.hashCode()));

Set<PlayingCard> deck = new HashSet<>();

       for(PlayingCard p : cards){
           if (!deck.add(p)){
               System.out.println("Duplicate found "+p);
           }
       }
        System.out.println(deck);

    }
}
