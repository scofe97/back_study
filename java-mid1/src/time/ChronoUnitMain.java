package time;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitMain {
    public static void main(String[] args) {
        ChronoUnit[] values = ChronoUnit.values();
        for (ChronoUnit value : values) {
            System.out.println("value = " + value);
        }

        System.out.println(ChronoUnit.HOURS);
        System.out.println("Hours.duration = " + ChronoUnit.HOURS.getDuration().getSeconds());
        System.out.println("Days = " + ChronoUnit.DAYS);

        LocalTime localTime1 = LocalTime.of(1, 10, 0);
        LocalTime localTime2 = LocalTime.of(1, 20, 0);

        long secondsBetween = ChronoUnit.SECONDS.between(localTime1, localTime2);
        System.out.println("secondsBetween = " + secondsBetween);

        long minutesBetween = ChronoUnit.MINUTES.between(localTime1, localTime2);
        System.out.println("minutesBetween = " + minutesBetween);
    }
}
