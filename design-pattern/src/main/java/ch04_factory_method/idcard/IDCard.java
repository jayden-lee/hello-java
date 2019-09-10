package ch04_factory_method.idcard;

import ch04_factory_method.framwork.Product;

import java.text.MessageFormat;

public class IDCard extends Product {

    private String owner;

    IDCard(String owner) {
        System.out.println(MessageFormat.format("{0}의 카드를 만듭니다.", owner));
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(MessageFormat.format("{0}의 카드를 사용합니다.", owner));
    }

    public String getOwner() {
        return owner;
    }
}
