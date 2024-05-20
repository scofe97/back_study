import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Functional {

    // consumer
    @Test
    @DisplayName("consumer")
    public void consumer() {
        Consumer<String> eat = food -> System.out.println("food = " + food);
        eat.accept("응애");
    }

    // supplier
    @Test
    @DisplayName("supplier")
    public void supplier() {
        Supplier<Integer> salary = () -> 300;
        Integer i = salary.get();
        System.out.println("i = " + i);
    }

    // function
    @Test
    @DisplayName("function")
    public void function() {
        Function<BigDecimal, BigDecimal> exchange = (dallar) -> {
            return dallar.multiply(BigDecimal.valueOf(1600));
        };

        BigDecimal exchanged = exchange.apply(BigDecimal.valueOf(43.27));
        assertEquals(BigDecimal.valueOf(69232).doubleValue(), exchanged.doubleValue());
    }

    // predicate
    @Test
    @DisplayName("predicate")
    public void predicate() {
        Predicate<String> predicate = (name) -> {
            return "jan".equals(name);
        };
        boolean result = predicate.test("jan");
        System.out.println("result = " + result);
    }

    // 함수형 프로그래밍 응용
    @Test
    @DisplayName("응용")
    public void functionalParams() {

        Function<Integer, Grade> schoolGradeCalcurator = (score) -> {
            int gradeNum = score / 10;
            Grade result = switch (gradeNum) {
                case 9 -> Grade.A;
                case 8 -> Grade.B;
                case 7 -> Grade.C;
                case 6 -> Grade.D;
                default -> Grade.E;
            };
            return result;
        };

        Grade gradeByScore = getGradeByScore(67, schoolGradeCalcurator);
        assertEquals(Grade.A, gradeByScore);


    }

    private Grade getGradeByScore(int score, Function<Integer, Grade> calcurator) {
        return calcurator.apply(score);
    }

    enum Grade{
        A,B,C,D,E,F
    }
}
