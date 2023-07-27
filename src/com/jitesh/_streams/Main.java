package com.jitesh._streams;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static int counter=0;
    public static void main(String[] args) {
        List<String> bingoPool = new ArrayList<>(75);
        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < (start + 15); i++) {
                bingoPool.add("" + c + i);
            }
            start += 15;
        }

        Collections.shuffle(bingoPool);
        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("-------------------------");
        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0, 15));
        firstOnes.sort(Comparator.naturalOrder());

        firstOnes.replaceAll(s -> {
            if (s.indexOf("G") == 0 || s.indexOf("O") == 0) {
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.print(updated + " ");
                return updated;
            }
            return s;
        });

        System.out.println("\n----------------------");
        bingoPool.stream()
                .limit(15)
                .filter(s -> (s.indexOf("G") == 0 || s.indexOf("O") == 0))
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted()
                .forEach(s -> System.out.println(s + " "));
        System.out.println("\n----------------------");

        String[] strings = {"One", "Two", "Three"};
        var firstStream = Arrays.stream(strings)
                .sorted(Comparator.reverseOrder());
//                .forEach(System.out::println);

        var secondStream = Stream.of("four", "five", "six")
                .map(String::toUpperCase);
//                .forEach(System.out::println);

        Stream.concat(secondStream, firstStream)
                .map(s -> s.charAt(0) + "-" + s)
                .forEach(System.out::println);
        System.out.println("\n----------------------");
        Map<Character, int[]> myMap = new LinkedHashMap<>();

        int bingoIndex = 1;
        for (char c : "BINGO".toCharArray()) {
            int labelNo = bingoIndex;
            int[] numbers = new int[15];
            Arrays.setAll(numbers, i -> i + labelNo);
            myMap.put(c, numbers);
            bingoIndex += 15;

        }
        myMap.entrySet()
                .stream()
                .map(e -> e.getKey() + " has range " + e.getValue()[0] + " - " + e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println);
        System.out.println("\n----------------------");

        Random random = new Random();
        Stream.generate(() -> random.nextInt(2))
                .limit(20)
                .forEach(s -> System.out.print(s + " "));
        System.out.println("\n----------------------");
            Stream.iterate(1,n->n+1)
                    .filter(Main::isPrime)
                    .limit(20)
                    .forEach(s -> System.out.print(s + " "));

        System.out.println("\n----------------------");
        IntStream.iterate(1, n->n+1)
                .limit(100)
                .filter(Main::isPrime)
                .forEach(s -> System.out.print(s + " "));
        System.out.println("\n----------------------");
 
        IntStream.iterate(1,n->n<=100, n->n+1)
                .filter(Main::isPrime)
                .forEach(s -> System.out.print(s + " "));
        IntStream.range(1,100)
                .filter(Main::isPrime)
                .forEach(s -> System.out.print(s + " "));

        System.out.println("\n----------------------");


int seed =1;
     var firstB=Stream.iterate(seed,i->i<=15,i->i+1)
             .map(i->"B"+i);
           firstB.forEach(System.out::println);
           seed+=15;
    var secondI=Stream.iterate(seed,i->i+1)
            .limit(15)
                    .map(i->"I"+i);
        secondI.forEach(System.out::println);

        String[] labelN = new String[15];
        seed+=15;
        int nSeed = seed;
        Arrays.setAll(labelN,i-> "N"+ (nSeed+i));
        var thirdN =Stream.of(labelN);
        thirdN.forEach(System.out::println);
        var streamG = Stream.of("G46", "G47", "G48", "G49", "G50",
                "G51", "G52", "G53", "G54", "G55", "G56", "G57", "G58", "G59", "G60");

        seed += 15;
        int rSeed = seed;

        var streamO=Stream.generate(Main::getCounter)
                .limit(15)
                .map(i->"O"+(rSeed+i));
 var streamBI=Stream.concat(firstB,secondI);
 var streamNG=Stream.concat(thirdN,streamG);
        var streamBING = Stream.concat(streamBI, streamNG);
        Stream.concat(streamBING, streamO)
                .forEach(System.out::println);
    }


    public static boolean isPrime(int wholeNumber){
        if (wholeNumber<=2){
            return (wholeNumber==2);
        }
        for (int divisor = 2; divisor <wholeNumber ; divisor++) {
            if (wholeNumber%divisor==0) return false;
        }
return true;
    }
    private static int getCounter() {
        return counter++;
    }


}
