package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Chapter6Test {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
        LocalDateTime answer1 = localDateTime
                .plusYears(1)
                .plusMonths(2)
                .plusDays(3)
                .plusHours(4);
        System.out.println("answer1 = " + answer1);


        LocalDate localDate = LocalDate.of(2024, 1, 1);
        for (int i = 0; i < 5; i++) {
            System.out.println("날짜" + i + ": " + localDate);
            localDate = localDate.plusDays(14);
        }


        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 11, 21);

        Period between = Period.between(startDate, endDate);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("between.getYears() = " + between.getYears());
        System.out.println("between.getMonths() = " + between.getMonths());
        System.out.println("between.getDays() = " + between.getDays());
        System.out.println("daysBetween = " + daysBetween);

    }
}
