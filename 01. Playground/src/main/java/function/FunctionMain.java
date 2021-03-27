package function;

import java.util.function.Function;

public class FunctionMain {

    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = number -> number + 10;
        Function<Integer, Integer> multiply2 = number -> number * 2;

        // 30
        System.out.println(plus10.compose(multiply2).apply(10));

        // 40
        System.out.println(plus10.andThen(multiply2).apply(10));
    }
}
