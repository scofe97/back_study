package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdujstMain {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);

        LocalDate nextMonday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("nextMonday = " + nextMonday);

        LocalDate lastFriday = now.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        System.out.println("lastFriday = " + lastFriday);
    }
}
