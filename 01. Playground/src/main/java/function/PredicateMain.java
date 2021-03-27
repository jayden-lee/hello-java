package function;

import java.util.function.Predicate;

public class PredicateMain {

    public static void main(String[] args) {
        Predicate<Integer> evenPredicate = number -> number % 2 == 0;

        // false
        System.out.println(evenPredicate.test(5));

        // true
        System.out.println(evenPredicate.test(6));
    }
}
