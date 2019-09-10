package ch03_template_method;

public class StringDisplay extends AbstractDisplay {

    private String text;
    private int width;

    public StringDisplay(String text) {
        this.text = text;
        this.width = text.length();
    }

    @Override
    void open() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    @Override
    void print() {
        System.out.println("|" + text + "|");
    }

    @Override
    void close() {
        printLine();
    }
}
