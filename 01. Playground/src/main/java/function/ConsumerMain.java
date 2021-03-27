package function;

import java.util.function.Consumer;

public class ConsumerMain {

    public static void main(String[] args) {
        Consumer<Integer> printNumber = number -> System.out.println(number);
        printNumber.accept(10);
    }
}
