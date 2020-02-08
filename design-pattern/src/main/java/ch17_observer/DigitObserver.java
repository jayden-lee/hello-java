package ch17_observer;

/**
 * 관찰한 수를 숫자로 표시하는 관찰자 클래스
 */
public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver: " + generator.getNumber());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // ignore
        }
    }
}
