package ch02_adapter;

public class PrintImpl extends AbstractPrint {

    private Banner banner;

    public PrintImpl(String text) {
        banner = new Banner(text);
    }

    @Override
    void printWeak() {
        banner.showWithPattern();
    }

    @Override
    void printStrong() {
        banner.showWithAster();
    }
}
