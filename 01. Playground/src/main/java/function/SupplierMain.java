package function;

import java.util.function.Supplier;

public class SupplierMain {

    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> 10;
        System.out.println(supplier.get());
    }
}
