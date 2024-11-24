package org.example.functional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestJava {
    public static void main(String[] args) {

        // 정적 메서드 참조 ClassName::staticMethodName
        Function<Integer, String> asRef = Integer::toHexString;

        // 바운드 비정적 메서드 objectName::instanceMethodName
        var now = LocalDate.now();
        Predicate<LocalDate> isAfterNowAsRef = now::isAfter;
        Predicate<LocalDate> isBeforeNowAsRef = now::isBefore;

        // 언바운드 비정적 메소드 ClassName::instanceMethodName
        Function<String ,String> toLowerCaseRef = String::toLowerCase;

        // 생성자 참조
        Function<String, BigDecimal> newLocalRef = BigDecimal::new;
    }
}
