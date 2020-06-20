package ch06_prototype;

public class UnderlinePen implements Product {

    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int length = s.length();
        System.out.println("\"" + s + "\"");

        System.out.print("");

        for (int i = 0; i < length; i++) {
            System.out.print(ulchar);
        }

        System.out.println();
    }

    @Override
    public Product createClone() {
        Product product = null;

        try {
            product = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return product;
    }
}
