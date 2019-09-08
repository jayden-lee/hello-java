package ch02_adapter;

public class Main {

    public static void main(String[] args) {
        // 클래스 상속, 인터페이스 구현을 통한 어댑터 패턴 구현
        Print print = new PrintBanner("Hello");
        print.printWeak();
        print.printStrong();

        System.out.println();

        // 위임을 통한 어댑터 패턴 구현
        AbstractPrint abstractPrint = new PrintImpl("Hello");
        abstractPrint.printWeak();
        abstractPrint.printStrong();
    }
}
