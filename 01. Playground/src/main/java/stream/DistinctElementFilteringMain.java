package stream;

import java.util.Arrays;
import java.util.List;

/**
 * 고유 요소 필터링
 */
public class DistinctElementFilteringMain {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 3, 2, 1, 4, 5, 6);
        numbers.stream()
            .filter(i -> {
                System.out.println("element: " + i);
                return i % 2 == 0;
            })
            .distinct()
            .forEach(System.out::println);
    }
}
