package labdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Person(String fName,String lName){
        @Override
        public String toString() {
            return fName + " " + lName;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Main.Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")));


        var comparator= new Comparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                return o1.fName.compareTo(o2.fName);
            }
        };

        people.sort((o1, o2) -> o1.fName.compareTo(o2.fName));
        for (Person p : people){
            System.out.println(p.fName);
        }

      interface  EnhancedComparator<T> extends Comparator<T>{
          int secondLevel(T o1, T o2);
      }
        var comparatorMixed=new EnhancedComparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lName().compareTo(o2.lName());
                return result==0?secondLevel(o1,o2):result;
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.fName.compareTo(o2.fName);
            }
        };

            people.sort(comparatorMixed);

        System.out.println();
        System.out.println(people);
    }

}
