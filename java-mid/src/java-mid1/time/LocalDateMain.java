package time;

import java.time.LocalDate;

public class LocalDateMain {

    public static void main(String[] args) {

        // 생성
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.of(2013, 11, 21);

        System.out.println("now = " + now);
        System.out.println("localDate = " + localDate);

        // 계산
        LocalDate localDate1 = localDate.plusDays(10);
        System.out.println("localDate1 = " + localDate1);

        // 모든 날짜 클래슨는 불변이다.
    }
}
