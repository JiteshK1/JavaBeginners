package com.jitesh.labda_expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodChaining {
    public static void main(String[] args) {
    String name = "jitesh";
        Function<String,String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));
        Function<String,String> lastCase = s-> s.concat("Kanyalkar");
        Function<String,String> uAnotherCase = uCase.andThen(lastCase);
        System.out.println(uAnotherCase.apply(name));

        Function<String,String[]> f0= uCase.andThen(s-> s.concat(" Kanyalkar")).andThen(s-> s.split(" "));

        System.out.println(Arrays.toString(f0.apply(name)));

        Function<String,String> f1 = uCase.andThen(s-> s.concat(" kanyalkar"))
                .andThen(s-> s.split(" "))
                .andThen(s-> s[1].toLowerCase() + "," +s[0]);
        System.out.println(f1.apply(name));

    String[] names = {"Anna","Bob","Chamber"};
        Consumer<String> s0 = s-> System.out.print( s.charAt(0)) ;
         Consumer<String> s1= System.out::println;

    Arrays.asList(names).forEach(s0.andThen(s-> System.out.print("-")).andThen(s1));

        Predicate<String> p0= s-> s.equals("jitesh");
        Predicate<String> p1 = s-> s.equalsIgnoreCase("jitesh");
        Predicate<String> p2 =s-> s.startsWith("j");
        Predicate<String> p3 =s-> s.endsWith("l");
    Predicate<String> combined = p0.or(p1);
        System.out.println(combined.test(name));
        Predicate<String> combined1 = p2.and(p3);
        System.out.println(combined1.test(name));
        Predicate<String> combined2 = p2.and(p3).negate(); //opposite
        System.out.println(combined2.test(name));

        record Person(String firstName, String lastName) {}

        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse")
        ));

        list.sort((o1,o2)->o1.lastName.compareTo(o2.lastName));
         list.forEach(System.out::println);

        System.out.println("------------------------------------");
         list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);
        System.out.println("------------------------------------");
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName));
        list.forEach(System.out::println);

    }
}
