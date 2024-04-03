package time;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalTimeMain {

    public static void main(String[] args) {
        // 생성
        LocalTime now = LocalTime.now();
        LocalTime ofTime = LocalTime.of(9, 10, 30);

        System.out.println("now = " + now);
        System.out.println("ofTime = " + ofTime);

        LocalTime localTime = ofTime.plusSeconds(30);
        System.out.println("localTime = " + localTime);

    }
}
