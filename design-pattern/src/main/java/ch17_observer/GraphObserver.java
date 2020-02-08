package ch17_observer;

/**
 * 관찰한 수를 간이 그래프로 표시하는 관찰자 클래스
 */
public class GraphObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.print("GraphObserver:");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // ignore
        }
    }
}
