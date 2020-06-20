package ch14_chain_of_responsibility;

/**
 * 특정 번호를 갖고 있는 Trouble 클래스
 */
public class Trouble {

    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[Trouble " + number + "]";
    }
}
