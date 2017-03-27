import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Yeison Melo {@literal <mailto:melo.yeison@gmail.com/>}
 *         Class to study Java 8 new features
 *
 */

public class Stream {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("A", "B", "C", "D", "E","", "F", "G");

        //Parallel processing of collections to use multicore systems but doesn't warranty orden
        strings.parallelStream().map(n -> n + " ").forEach(System.out::print);
        System.out.println("");

        //Map, Collectors and for each stream
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        Set<Integer> result = integers.stream().filter(n -> n > 3 && n < 10).collect(Collectors.toSet());
        result.stream().map(n -> n*2 + " ").forEach(System.out::print);
        System.out.println("");


        //Sort stream of 10 random ints
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

    }
}
