package ch02_adapter;

public class Banner {

    private String text;

    public Banner(String text) {
        this.text = text;
    }

    public void showWithPattern() {
        System.out.println("(" + text + ")");
    }

    public void showWithAster() {
        System.out.println("*" + text + "*");
    }
}
