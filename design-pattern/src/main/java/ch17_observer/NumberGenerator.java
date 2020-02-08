package ch17_observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자를 생산하는 추상 클래스
 */
public abstract class NumberGenerator {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 관찰자들한테 변경 사항을 알림
     */
    public void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }

    public abstract int getNumber();

    public abstract void execute();
}
