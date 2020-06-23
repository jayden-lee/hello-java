package stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 스트림 만들기
 */
public class StreamCreationMain {

    public static void main(String[] args) {
        // 값으로 스트림 생성
        Stream<String> stringStream = Stream.of("Java", "Kotlin", "Go");
        stringStream.map(String::toUpperCase).forEach(System.out::println);

        // 배열로 스트림 생성
        int[] numbers = {2, 3, 5, 6, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        // 파일로 스트림 생성
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource("data.txt").toURI()), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (URISyntaxException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(uniqueWords);

        // 함수로 무한 스트림 생성
        IntStream.iterate(0, n-> n+4)
            .limit(10) // takeWhile(predicate)
            .forEach(System.out::println);

        Stream.generate(Math::random)
            .limit(5)
            .forEach(System.out::println);
    }
}
