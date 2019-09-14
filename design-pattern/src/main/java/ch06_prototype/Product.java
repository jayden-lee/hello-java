package ch06_prototype;

public interface Product extends Cloneable {
    void use(String s);
    Product createClone();
}
