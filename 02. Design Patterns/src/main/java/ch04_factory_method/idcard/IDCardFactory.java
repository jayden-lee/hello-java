package ch04_factory_method.idcard;

import ch04_factory_method.framwork.Factory;
import ch04_factory_method.framwork.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {

    private List<String> owners = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(product.getOwner());
    }

    public List<String> getOwners() {
        return owners;
    }
}
