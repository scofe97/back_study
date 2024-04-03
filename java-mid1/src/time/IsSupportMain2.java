package time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class IsSupportMain2 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        if (now.isSupported(ChronoField.SECOND_OF_MINUTE)) {
            int i = now.get(ChronoField.SECOND_OF_MINUTE);
            System.out.println("i = " + i);
        }
    }
}
