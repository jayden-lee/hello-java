package time;

import java.time.Instant;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Java 8 Time API에 추가된 Instant 클래스는 시간을 타임스탬프로 다루기 위해서 사용
 */
public class InstantMain {

    public static void main(String[] args) {
        Instant epoch = Instant.EPOCH;
        System.out.println("epoch = " + epoch); // 1970-01-01T00:00:00Z

        Instant epochInFuture = Instant.ofEpochSecond(1_000_000_000);
        System.out.println("epochInFuture = " + epochInFuture); // 2001-09-09T01:46:40Z

        Instant epochInPast = Instant.ofEpochSecond(-1_000_000_000);
        System.out.println("epochInPast = " + epochInPast); // 1938-04-24T22:13:20Z

        Instant now = Instant.now();
        System.out.println("current instant = " + now);
        System.out.println("seconds = " + now.getEpochSecond()); // 초단위 타임스탬프
        System.out.println("milli seconds = " + now.toEpochMilli()); // 밀리 초 단위 타임스탬프

        ZonedDateTime zdtSeoul = Year.of(2002).atMonth(6).atDay(18).atTime(20, 30).atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("Time in Seoul = " + zdtSeoul); // 2002-06-18T20:30+09:00[Asia/Seoul]

        Instant instantSeoul = zdtSeoul.toInstant();
        System.out.println("Instant = " + instantSeoul); // 2002-06-18T11:30:00Z, UTC 기준 9시간 느린 11시 30분
    }
}
