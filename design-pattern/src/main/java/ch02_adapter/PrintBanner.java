package ch02_adapter;

import java.security.Principal;

public class PrintBanner extends Banner implements Print {

    public PrintBanner(String text) {
        super(text);
    }

    @Override
    public void printWeak() {
        showWithPattern();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
