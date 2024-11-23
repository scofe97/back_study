package org.example.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

// 사용자 정의 Predicate 인터페이스
interface LikePredicate<T> {
    boolean test(T value);
}

public class TestMain3 {
    public static void main(String[] args) {
        // LikePredicate 인터페이스를 사용한 람다 표현식
        LikePredicate<String> isNull = value -> value == null;  // 1

        // 아래 코드에서는 컴파일 오류 발생 (타입 호환 불가)
        // Predicate<String> wontCompile = isNull;  // 2
        // 오류:
        // 호환되지 않는 타입: LikePredicate<java.lang.String>은
        // java.util.function.Predicate<java.lang.String>으로 변환될 수 없음

        // filter1 사용 예시
        var values = Arrays.asList("a", null, "c");
        var result1 = filter1(values, Objects::nonNull);  // Predicate 사용

        // filter2 사용 예시
        var result2 = filter2(values, Objects::nonNull);  // LikePredicate 사용

        // 결과 출력
        System.out.println(result1); // 출력: [a, c]
        System.out.println(result2); // 출력: [a, c]


    }

    // java.util.function.Predicate를 사용한 필터링 메서드
    static List<String> filter1(List<String> values, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String value : values) {
            if (predicate.test(value)) {
                result.add(value);
            }
        }
        return result;
    }

    // 사용자 정의 LikePredicate를 사용한 필터링 메서드
    static List<String> filter2(List<String> values, LikePredicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String value : values) {
            if (predicate.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
