package time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DurationMain {

    public static void main(String[] args) {

        Duration duration = Duration.ofMinutes(30);
        System.out.println("duration = " + duration);

        LocalTime lt = LocalTime.of(1, 0);
        System.out.println("lt = " + lt);

        LocalTime plus = lt.plus(duration);
        System.out.println("plus = " + plus);

        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(10, 0);
        Duration between = Duration.between(start, end);
        System.out.println("between = " + between.getSeconds());
        System.out.println("근무 시간: " + between.toHours() + "시간" + between.toMinutesPart() + "분");

    }
}
