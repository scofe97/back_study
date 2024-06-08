package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingMain2 {
    public static void main(String[] args) {

        // 포맷팅: 날짜와 시간을 문자로
        LocalDateTime now = LocalDateTime.of(2024, 12, 31, 13, 30, 59);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now.format(formatter);
        System.out.println("format = " + format);
        System.out.println("now = " + now);

        // 파싱
        String dateTimeString = "2023-01-01 11:30:00";
        LocalDateTime parseDateTime = LocalDateTime.parse(dateTimeString, formatter);
        System.out.println("parseDateTime = " + parseDateTime);
    }
}
