package ch03_template_method;

public class Main {

    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('Y');
        AbstractDisplay d2 = new StringDisplay("Hello Java!");

        d1.display();
        d2.display();
    }
}
