package streams;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        IntStream.iterate((int)'A',n-> n<=(int)'z',n->n+1)
                .filter(Character::isAlphabetic)
//                .dropWhile(n-> Character.toUpperCase(n)<='E')
                .takeWhile(n->n<'a')
//                .skip(5)
//                .filter(n->Character.toUpperCase(n)>='E')
                .forEach(d->System.out.printf("%c ",d));

        System.out.println();
        Random random = new Random();

        Stream.generate(()-> random.nextInt((int)'A',(int)'Z'+1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(d-> System.out.printf("%c ",d));
        System.out.println();
        int maxSeats = 100;
        int seatsInRow = 10;
    var streams =Stream.iterate(0,i->i<100,i->i+1)
            .map(i->new Seat((char)('A'+i/seatsInRow),i%seatsInRow+1))
                    .skip(5)
                            .limit(10)
                                    .peek(s-> System.out.println("-->"+s))
                                            .sorted(Comparator.comparing(Seat::price).thenComparing(Seat::toString));
//                    .mapToDouble(Seat::price)
//                      .boxed()
//                .map("%.2f"::formatted);

    streams.forEach(System.out::println);
    }
}
