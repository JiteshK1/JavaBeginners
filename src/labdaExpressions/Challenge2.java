package labdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Challenge2 {
    private static  Random random = new Random();
    public static void main(String[] args) {
        String[] arr = {"BasKr", "praKsh", "BOb", "lvmBBodhr", "HariKurt"};


            Arrays.setAll(arr, i->arr[i].toUpperCase() );
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));

        List<String> list = new ArrayList<>(Arrays.asList(arr));

            list.replaceAll(sentence-> sentence+ " "+ getRandomChar('A','D'));
        System.out.println(list);
            Arrays.asList(arr).forEach(s-> System.out.println(s));

    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int)startChar , (int) endChar +1 );

    }
}
