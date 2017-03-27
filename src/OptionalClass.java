import java.util.Optional;
import java.util.Random;

/**
 * @author Yeison Melo {@literal <mailto:melo.yeison@cabonline.com/>}
 *         Class to study Java 8 new features
 * Optional is not serializable so should not be used in the domain layer
 * We could return a null but, what happens if othe programmer is using
 * or method but doesn't know it can return a null value probably will
 * try to access and generate an exception with optional we make sure we
 * will not that the value maybe won't be present.
 * Should not be use when:
 * in the domain model layer (not serializable)
 * in DTOs (same reason)
 * in input parameters of methods
 * in constructor parameters
 */
public class OptionalClass {

    public static void main(String[] args) {

        Integer a = 12;
        Integer b = 2;

        if (OptionalClass.getValue().isPresent()) {
            System.out.println("Value is present: present");
        } else {
            System.out.println("Value is not present: present");
        }
    }

    /**
     * Very useful when the function may return a value or not
     */
    private static Optional<Integer> getValue() {
        Optional<Integer> result = null;

        Random random = new Random();
        if (random.ints().limit(1).toArray()[0] % 2 == 0) {
            result = Optional.of(5);
        }

        return result.empty();
    }
}
