package com.jitesh.collection;

import java.util.ArrayList;
import java.util.List;

public record  Card(Suit suit, String face, int rank) {

    public enum Suit{SPADE,DIAMOND,HEART,CLUB;

       public char getImage(){
          return (new char[]{9827,9830,9829,9824})[this.ordinal()];
       }

    };

    @Override
    public String toString() {
 // in all case it will be one but for 2 digit it will be 2
        int index = face.equals("10")?2:1;
        String faceString=face.substring(0,index);
       return "%s%c(%d)".formatted(faceString,suit.getImage(),rank);
    }
public static Card getNumericCard(Suit suit,int cardNumber){
        if (cardNumber>1 &&  cardNumber<11){
            return new Card(suit,String.valueOf(cardNumber),cardNumber-2);
        }
    System.out.println("Invalid card no");
    return null;
    }
public static Card getFaceCard(Suit suit,char abbrev){
        int charIndex= "JQKA".indexOf(abbrev);
        if (charIndex>-1){
            return new Card(suit,""+ abbrev,charIndex+9);
        }
    System.out.println("invalid face card");
return null;
    }
    public static List<Card> getStandardDeck(){
        List<Card> deck= new ArrayList<>(52);
        //values() use to retrieve evey enum constants
        for(Suit suit:Suit.values()){
            for (int i = 2; i <=10 ; i++) {
                 deck.add(getNumericCard(suit,i));
            }
            for (char c : new char[]{'J','Q','K','A'}){
                deck.add(getFaceCard(suit,c));
            }
        }
        return deck;
    }

    public static void printDeck(List<Card> deck,String Description,int row){
        System.out.println("-".repeat(40));
       if (Description!= null){
           System.out.println(Description);
       }
       int cardInRow=deck.size()/row;
        for (int i = 0; i < row; i++) {
            int StartIndex=i*cardInRow;
            int endIndex= StartIndex+cardInRow;
                  deck.subList(StartIndex,endIndex).forEach(c-> System.out.print(c+" "));
            System.out.println();

        }
    }
    public static void  printDeck(List<Card> deck){
        printDeck(deck,"Current deck",4);
    }
}
