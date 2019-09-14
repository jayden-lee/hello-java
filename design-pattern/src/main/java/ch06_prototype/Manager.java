package ch06_prototype;

import java.util.HashMap;
import java.util.Map;

public class Manager {

    private Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product product) {
        showcase.put(name, product);
    }

    public Product create(String productName) {
        Product product = showcase.get(productName);
        return product.createClone();
    }
}
