package List;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Linked {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
//        var placesToVisit=new LinkedList<String>();
        placesToVisit.add("Kolkata");
        placesToVisit.add(0, "Himachal");
        addPlaces(placesToVisit);
//        removePlaces(placesToVisit);
        System.out.println(placesToVisit);
//        printItinernary3(placesToVisit);
        testIterator2(placesToVisit);
        //        getElements(placesToVisit);

    }

    public static void addPlaces(LinkedList<String> places) {
        places.addFirst("MahaeshVar");
        places.addLast("Tirupati");
        //Queue
        places.offer("Trigger");
        places.offerFirst("ChingChing")
        ;
        places.offerLast("Malaysia");
        //Stack
        places.push("Pandu");
    }

    public static void removePlaces(LinkedList<String> places) {
        places.remove("MahaeshVar");

        String s1 = places.remove();//removes FirstElement
        System.out.printf("%s  was removed %n", s1);
        String s2 = places.poll(); //removes first element
        System.out.println(s2 + "was removed");


    }

    public static void getElements(LinkedList<String> places) {
        System.out.println("Element retrieved is " + places.get(4));
        System.out.println("First retrieved is " + places.getFirst());
        System.out.println("Last retrieved is " + places.getLast());
        System.out.println("ChingChing is at " + places.indexOf("ChingChing"));
        System.out.println("Kolkata is at " + places.lastIndexOf("Kolkata"));
        //queue
        System.out.println("Returns first element " + places.element());
        // Stack
        System.out.println("Returns Element " + places.peek());
        System.out.println("Returns Element " + places.peekFirst());
        System.out.println("Returns Element " + places.peekLast());

    }

    public static void printItinernary(LinkedList<String> places) {
        System.out.print("Trip starts from " + places.getFirst());
        System.out.println(" And Trip End At " + places.getLast());

        for (int i = 1; i < places.size(); i++) {
            System.out.println(places.get(i - 1) + " to " + places.get(i));
        }


    }
    public static void testIterator(LinkedList<String> places) {
        Iterator<String> iterator = places.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("Kolkata")){
                iterator.remove();
            }
        }
        System.out.println(places);

    }
    public static void testIterator2(LinkedList<String> places) {
        ListIterator<String> iterator = places.listIterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("Kolkata")){
                iterator.add("Shikakai");
            }
        }
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());

        }
        System.out.println(places);



    }
    public static void printItinernary3(LinkedList<String> places) {
        System.out.println("Trip starts from " + places.getFirst());
        String previousTown = places.getFirst();
        ListIterator<String> iterator = places.listIterator(1);
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("From " + previousTown + " to " + town);
            previousTown = town;

        }
    }

}

