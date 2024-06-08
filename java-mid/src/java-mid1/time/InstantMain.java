package time;

import java.time.Instant;
import java.time.ZonedDateTime;

public class InstantMain {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("now = " + now); // UTC 기준

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Instant from = Instant.from(zonedDateTime);
        System.out.println("from = " + from);

        Instant epochSecond = Instant.ofEpochSecond(10);
        System.out.println("instant = " + epochSecond);

        // 계산
        Instant instant = epochSecond.plusSeconds(3600);
        System.out.println("instant = " + instant);

        // 조회
        long epochSecond1 = instant.getEpochSecond();
        System.out.println("epochSecond1 = " + epochSecond1);
    }
}
