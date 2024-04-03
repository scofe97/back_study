package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingMain1 {
    public static void main(String[] args) {

        // 포맷팅: 날짜를 문자로
        LocalDate localDate = LocalDate.of(2024, 12, 31);
        System.out.println("localDate = " + localDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String format = localDate.format(formatter);
        System.out.println("format = " + format);

        // 파싱: 문자를 날짜로
        String input = "2030년 01월 01일";
        LocalDate parseDate = LocalDate.parse(input, formatter);
        System.out.println("parseDate = " + parseDate);
    }
}
