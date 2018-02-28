import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * @author Yeison Melo {@literal <mailto:melo.yeison@gmail.com/>}
 *         Class to study Java 8 new features
 */

public class FunctionalInterfaces {

    public static void main(String[] args) {

        //Lamda expression to define inline implementation of a functional interface
        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation division = (a, b) -> a / b;


        System.out.println("10 + 5 = " + operate(10, 5, addition));
        System.out.println("10 - 5 = " + operate(10, 5, subtraction));
        System.out.println("10 / 5 = " + operate(10, 5, division));


        //Java has defined a lot of functional interfaces with generics so we online need to implement their behavior
        //BiFunction<P1,P2,R> receives two parameter of type P1 and P2 respectively and return one of type R
        BiFunction<Integer, Long, String> func = (a,b) -> a+""+b;
        System.out.println(func.apply(10,20L));

        //Predicate<T> Represents a predicate (Boolean-valued function) of one argument.
        List<Integer> places = Arrays.asList(1,2,3,4,5,6);
        eval(places, i -> i%2==0);
       

    }

    /**
     * Functional interface, interface with only one method
     */
    interface MathOperation {
        int operation(int a, int b);
    }

    /**
     * Aux method to avoid calls to .operation for every implementation of MathOperation
     */
    private static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    /**
     * Function with a "function" as parameter
     */
    private static void eval(List<Integer> l, Predicate<Integer> predicate){
        for(Integer i: l){
            if(predicate.test(i)){
                System.out.println(i + " is even.");
            }
        }
    }
}
