package com.jitesh.collection;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Card[] deck = new Card[13];

        Card aceOfHearts =Card.getFaceCard(Card.Suit.HEART,'A');

        Arrays.fill(deck,aceOfHearts);
        Card.printDeck(Arrays.asList(deck),"Aces",1);

        List<Card> acesOfHearts = Collections.nCopies(13,aceOfHearts);
        Card.printDeck(acesOfHearts,"NewAces",1);

       Card kingOfClub= Card.getFaceCard(Card.Suit.CLUB,'K');
       List<Card> kingsOfClub=Collections.nCopies(13,kingOfClub);
       Card.printDeck(kingsOfClub,"Kings",1);

    List<Card> cards = new ArrayList<>(52);
    Collections.fill(cards,aceOfHearts);
        System.out.println(cards.size());

        Collections.addAll(cards,deck);
        Collections.addAll(cards,deck);
        Card.printDeck(cards,"NEWWWW",2);
//adds 24 total elements in the cards dek
        Collections.copy(cards,kingsOfClub);
        Card.printDeck(cards,"OOO",2);
              //it replaces the card elemeent with the kindsOFCLub do
          cards=List.copyOf(kingsOfClub);
// it returns a copy of cards dek
          Card.printDeck(cards,"WAkaMole",1);



        List<Card> mainDeck = Card.getStandardDeck();
        Card.printDeck(mainDeck);

        Collections.reverse(mainDeck);
        Card.printDeck(mainDeck);

        var sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);

        Collections.sort(mainDeck,sortingAlgorithm);

        Card.printDeck(mainDeck);

        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
       int foundIndex= Collections.binarySearch(mainDeck,tenOfHearts,sortingAlgorithm);
        System.out.println("Found index is " + foundIndex);
        System.out.println("Found index is " + mainDeck.indexOf(tenOfHearts));

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(mainDeck, tenOfClubs, tenOfHearts);
        Card.printDeck(mainDeck.subList(32, 36), "Tens row", 1);
        System.out.println("Ten of Clubs Cards = " +
                Collections.frequency(mainDeck, tenOfHearts));
        System.out.println("Best Card = " + Collections.max(mainDeck, sortingAlgorithm));
        System.out.println("Worst Card = " + Collections.min(mainDeck, sortingAlgorithm));

        var sortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);
        mainDeck.sort(sortBySuit);
        Card.printDeck(mainDeck, "Sorted by Suit, Rank", 4);

       List<Card> copied = new ArrayList<>(mainDeck.subList(0,13));
        System.out.println("Normal :" + copied);

       Collections.reverse(copied);
        System.out.println("Using reverse :" + copied);

    }
}
