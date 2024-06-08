package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {
    public static void main(String[] args) {
        LocalDateTime nowDt = LocalDateTime.now();
        LocalDateTime ofDt = LocalDateTime.of(2016, 8, 16, 8, 10, 1);

        LocalDate localDate = ofDt.toLocalDate();
        LocalTime localTime = ofDt.toLocalTime();

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime = " + localDateTime);

        LocalDateTime localDateTime1 = ofDt.plusDays(1000);
        LocalDateTime localDateTime2 = ofDt.plusYears(1);
        System.out.println("localDateTime1 = " + localDateTime1);
        System.out.println("localDateTime2 = " + localDateTime2);

        System.out.println("시간 비교 " + nowDt.isAfter(ofDt));
        System.out.println("시간 비교 " + nowDt.isBefore(ofDt));
        System.out.println("시간 비교 " + nowDt.isEqual(ofDt)); // equals와 다르다. (단순 시간비교의 차이, equlas는 타임존도 비교해버림)
    }
}
