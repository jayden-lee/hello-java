package ch07_builder;

import java.util.List;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("타이틀");
        builder.makeContent("내용1");
        builder.makeItems(List.of("아이템1", "아이템2", "아이템3"));

        builder.makeContent("내용2");
        builder.makeItems(List.of("아이템4", "아이템5"));
        builder.close();
    }
}
