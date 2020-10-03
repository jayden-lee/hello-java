package date;

import java.time.Instant;

public class InstantMain {

    public static void main(String[] args) {
        Instant current = Instant.now();
        System.out.println("Current instant = " + current);

        long epochSecond = current.getEpochSecond();
        System.out.println("Current Timestamp in seconds = " + epochSecond);

        long epochMilli = current.toEpochMilli();
        System.out.println("Current Timestamp in milli seconds = " + epochMilli);
    }
}
