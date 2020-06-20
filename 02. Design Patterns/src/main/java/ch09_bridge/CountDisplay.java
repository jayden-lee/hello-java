package ch09_bridge;

import java.util.stream.IntStream;

/**
 * Display
 *  ㄴ CountDisplay
 *
 * CountDisplay는 Display 기능을 확장한 계층 클래스
 */
public class CountDisplay extends Display {

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        open();
        IntStream.range(0, times).forEach(i -> print());
        close();
    }
}
