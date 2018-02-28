import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yeison Melo {@literal <mailto:melo.yeison@gmail.com/>}
 * Class to study Java 8 new features
 */

public class Stream {

    public static void main(String[] args) {
        File file = new File("dataSet.csv");
        List<String> cities = new ArrayList<>();
        Scanner inputStream;
        int counter = 0;
        long start;

        try {
            inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                cities.add(inputStream.next().trim());
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        start = System.nanoTime();
        for (String city : cities) {
            if (city.equals("City")) {
                ++counter;
            }
        }
        System.out.println(counter);
        System.out.println("For loop time: " + (System.nanoTime() - start) / 1000000 + " ms");

        //execute parallel stream after stream or viceversa makes that the second goes much faster
        //otherwise they are almost equal
        start = System.nanoTime();
        System.out.println(cities.parallelStream()
                .filter(n -> n.equals("City"))
                .count());
        System.out.println("For loop time: " + (System.nanoTime() - start) / 1000000 + " ms");

        start = System.nanoTime();
        System.out.println(cities.stream()
                .filter(n -> n.equals("City"))
                .count());
        System.out.println("For loop time: " + (System.nanoTime() - start) / 1000000 + " ms");


        System.out.println(cities.stream()
                .filter(n->n.equals("City"))
                .reduce("",(a,b) -> a + b));
        
    }
}
