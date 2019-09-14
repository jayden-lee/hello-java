package ch09_bridge;

import java.util.stream.IntStream;

public class StringDisplayImpl extends DisplayImpl {

    private String text;
    private int width;

    public StringDisplayImpl(String text) {
        this.text = text;
        this.width = text.length();
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + text + "|");
    }

    @Override
    void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println("+");
    }
}
