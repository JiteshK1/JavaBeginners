package Collection.hashset;

import java.util.*;

public class TreeSetMain {

    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);

        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        NavigableSet<String> onlyName = new TreeSet<>();
         phones.forEach(c-> onlyName.add(c.getName()));
        System.out.println(onlyName);

          NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
          fullSet.addAll(emails);
          fullSet.forEach(System.out::println);

      List<Contact> fullList = new ArrayList<>(phones);
      fullList.addAll(emails);
      fullList.sort(sorted.comparator());
        System.out.println("---------------------------");
        fullList.forEach(System.out::println);

        Contact min =Collections.min(fullSet,fullSet.comparator());
        Contact max =Collections.max(fullSet,fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.println(min.getName()+" "+max.getName() );
        System.out.println(first+" "+last );


        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println(copiedSet.pollFirst());
        System.out.println(copiedSet.pollLast());

        copiedSet.forEach(System.out::println);
        System.out.println("---------------------------");
        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        fullSet.forEach(System.out::println);
        System.out.println("---------------------------");

        for(Contact c : List.of(daffy,daisy,snoopy,archie)){
            System.out.printf("ceiling (%s)= %s%n",c.getName(),fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));

        }
        System.out.println("---------------------------");

        for(Contact c : List.of(daffy,daisy,snoopy,archie)){
            System.out.printf("floor (%s)= %s%n",c.getName(),fullSet.floor(c));
            System.out.printf("lower(%s)=%s%n", c.getName(), fullSet.lower(c));

        }
        System.out.println("---------------------------");

        fullSet.forEach(System.out::println);
        System.out.println("---------------------------");

        NavigableSet<Contact> descendingSet= fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("---------------------------");

             Contact lastContact = descendingSet.pollLast();
        System.out.println("Removed " + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("--------------------------");
        fullSet.forEach(System.out::println);
        System.out.println("--------------------------");

        Contact marion = new Contact("Maid Marion");
        var headSet = fullSet.headSet(marion, true);
        headSet.forEach(System.out::println);
        System.out.println("--------------------------");

        var tailSet = fullSet.tailSet(marion,true);
        tailSet.forEach(System.out::println);
        System.out.println("--------------------------");

        Contact linus = new Contact("Linus Van Pelt");
        var subset = fullSet.subSet(linus,marion);
        subset.forEach(System.out::println);

    }


}
