package labdaExpressions;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Challenge {
    public static void main(String[] args) {


        Consumer<String> printWordLambda = (sentence -> {
            String[] parts = sentence.split(" ");
            for (String part :
                    parts) {
                System.out.println(part);
            }
        });
        Consumer<String> printWordConcise = (sentence -> Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s)));
        printWordLambda.accept("baba how are you");
        printWordConcise.accept("  a baba how are you");


        UnaryOperator<String> everySecondChar = ((String source) -> {
            StringBuilder returnValue = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1)
                    returnValue.append(source.charAt(i));
            }
            return returnValue.toString();
        });

        String result = everySingleMethod(everySecondChar, "123456789");
        System.out.println(result);

//        System.out.println(  everySecondChar.apply("1234567890"));

        Supplier<String> loveJava = () ->  {String supplyResult= "I love Java";
        return supplyResult;};
        System.out.println(loveJava.get());

    }

    public static String everySingleMethod(UnaryOperator<String> string, String s) {
        return string.apply(s);

    }
}
