package chapter7;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaTest {

    @Test
    void staticMethodReference(){
        // 메서드 레퍼런스
        Function<String, Integer> methodRef = Integer::parseInt;
        // 람다 표현식
        Function<String, Integer> lambda = str -> Integer.parseInt(str);

        // 사용 예
        System.out.println(methodRef.apply("100"));
        System.out.println(lambda.apply("100"));
    }

    @Test
    void boundMethodReference(){
        Instant then = Instant.now();

// 메서드 레퍼런스
        Predicate<Instant> methodRef = then::isAfter;
// 람다 표현식
        Predicate<Instant> lambda = t -> then.isAfter(t);

// 사용 예 (1초 후의 시간으로 테스트)
        Instant later = then.plusSeconds(1);
        System.out.println(methodRef.test(later));
        System.out.println(lambda.test(later));
    }

    @Test
    void unBoundMethodReference(){
        // 메서드 레퍼런스
        Function<String, String> methodRef = String::toLowerCase;
        // 람다 표현식
        Function<String, String> lambda = str -> str.toLowerCase();

        // 사용 예
        System.out.println(methodRef.apply("HELLO"));
        System.out.println(lambda.apply("HELLO"));
    }

    @Test
    void classMethodReference(){
// 메서드 레퍼런스
        Supplier<TreeMap<String, Integer>> methodRef = TreeMap<String, Integer>::new;
// 람다 표현식
        Supplier<TreeMap<String, Integer>> lambda = () -> new TreeMap<String, Integer>();

// 사용 예
        System.out.println(methodRef.get());
        System.out.println(lambda.get());
    }

    @Test
    void arrayMethodReference(){
// 메서드 레퍼런스
        Function<Integer, int[]> methodRef = int[]::new;
// 람다 표현식
        Function<Integer, int[]> lambda = len -> new int[len];

// 사용 예
        System.out.println(Arrays.toString(methodRef.apply(5)));
        System.out.println(Arrays.toString(lambda.apply(5)));
    }

    @Test
    void lambdaTest(){

        List<String> words = List.of("apple", "banana", "baby");
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        Collections.sort(words, Comparator.comparingInt(String::length));
        words.sort(Comparator.comparingInt(String::length));
    }

    @Test
    void streamTest() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");

        // 이름이 4글자인 사람들만 필터링하고 대문자로 변환
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() == 4)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(filteredNames); // [DAVE]

    }

    @Test
    void forTest(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
        List<String> filteredNames = new ArrayList<>();

        // 이름이 4글자인 사람들만 필터링하고 대문자로 변환
        for (String name : names) {
            if (name.length() == 4) {
                filteredNames.add(name.toUpperCase());
            }
        }

        System.out.println(filteredNames); // [DAVE]
    }

}
