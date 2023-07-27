package com.jitesh._list;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

record Place(String name,int distance){
    @Override
    public String toString() {
      return   String.format("%s (%d)",name,distance);
    }
}

public class Places {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();
           Place place = new Place("Sashikala",555);
        Place nadubar = new Place("Kolkata",225);
        Place paskol = new Place("Paskol",221);
        Place Mumbai = new Place("Mumbai",2125);

        addPlaces(placesToVisit,place);
        addPlaces(placesToVisit,nadubar);
        addPlaces(placesToVisit,paskol);
        addPlaces(placesToVisit,Mumbai);
        placesToVisit.addFirst(new Place("Shiroda",0));
        ListIterator<Place> iterator = placesToVisit.listIterator();

        boolean flag = true;
        boolean forward = true;
        showMenu();
        while (flag){


            if (!iterator.hasPrevious()){
                System.out.println("Originating from "+iterator.next());
            }
            if (!iterator.hasNext()){
                System.out.println("Final is "+iterator.previous());
            }
            System.out.println("Enter value :");
            switch (scanner.nextLine().toUpperCase().substring(0,1)){
                case "F" -> {System.out.println("User is Moving Forward");
                    if (!forward) {           // Reversing Direction
                        forward = true;
                        if (iterator.hasNext()) {
                            iterator.next();  // Adjust position forward
                        }
                    }

                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                }
                case "B" -> {System.out.println("User is Moving BackWord");
                    if (forward) {           // Reversing Direction
                        forward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();  // Adjust position backwards
                        }
                    }
                           if (iterator.hasPrevious()){
                               System.out.println(iterator.previous());
                           }
                }
                case "L" ->listItems(placesToVisit);
                case "M" -> showMenu();
                default -> flag= false;
            }
        }
    }


    public static void listItems(LinkedList<Place> places){
           ListIterator<Place> iterator = places.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    public static void   addPlaces(LinkedList<Place> places,Place place){
        if (places.contains(place)){
            System.out.println("Found Duplicate "+place);
            return;
        }
    int maxIndexValue=0;
    for(Place p : places){
        if (p.distance() > place.distance()){
            places.add(maxIndexValue,place);
            return;
        }else {
            maxIndexValue++;
        }
    }
        places.add(place);

    }

    public static  void  showMenu(){
        System.out.println("Available actions (select word or letter) : \n" +
                "(F)orword \n" +
                "(B)orword \n" +
                "(L)ist Places\n" +
                "(M)enu \n" +
                "(Q)uit \n  ");
    }

}
