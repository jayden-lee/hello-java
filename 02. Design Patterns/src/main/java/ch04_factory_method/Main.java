package ch04_factory_method;

import ch04_factory_method.framwork.Factory;
import ch04_factory_method.framwork.Product;
import ch04_factory_method.idcard.IDCardFactory;

public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();

        Product card1 = factory.create("jayden");
        card1.use();

        Product card2 = factory.create("ella");
        card2.use();

        Product card3 = factory.create("brayn");
        card3.use();
    }
}
