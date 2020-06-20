package ch05_singleton;

public class Main {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        if (s1 == s2) {
            System.out.println("s1과 s2는 같은 인스턴스입니다.");
        } else {
            System.out.println("s1과 s2는 다른 인스턴스입니다.");
        }
    }
}
