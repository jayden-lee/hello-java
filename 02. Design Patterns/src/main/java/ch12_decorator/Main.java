package ch12_decorator;

public class Main {

    public static void main(String[] args) {
        Display d1 = new StringDisplay("Hello world");
        Display d2 = new Sideborder(d1, '#');
        Display d3 = new FullBorder(d2);

        d1.show();
        d2.show();
        d3.show();

        Display d4 = new Sideborder(
                new FullBorder(
                        new FullBorder(
                                new Sideborder(
                                        new FullBorder(
                                                new StringDisplay("Hello World")
                                        ),
                                        '*'))
                        ), '/');

        d4.show();
    }
}
