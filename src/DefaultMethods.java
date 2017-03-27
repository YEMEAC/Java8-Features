/**
 * @author Yeison Melo {@literal <mailto:melo.yeison@cabonline.com/>}
 *         Class to study Java 8 new features
 */

public class DefaultMethods {

    public static void main(String[] args) {

        Cocodrile croco = new Cocodrile();

        croco.action();
        croco.talk();
        Aquatic.waterProof();

    }
}

/**
 * Interfaces now can have default methods implementation
 */
interface Reptil {
    default void action() {
        System.out.println("I can walk");
    }

    default void talk() {
        System.out.println("default methods can be overridden");
    }
}

/**
 * Interfaces now can have static methods
 */
interface Aquatic {
    default void action() {
        System.out.println("I can swim");
    }

    static void waterProof() {
        System.out.println("yes!");
    }
}

class Cocodrile implements Aquatic, Reptil {

    //handling ambious methods
    public void action() {
        Reptil.super.action();
        System.out.println("and");
        Aquatic.super.action();
    }

     public void talk() {
        System.out.println("default method have been overridden");
    }
}

