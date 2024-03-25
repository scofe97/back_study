package chapter7;

import org.example.chapter3.Member;
import org.example.chapter6.Operation;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class StreamTest {

    @Test
    void streamTest(){
        // 문자열 리스트
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        int[] nums = IntStream.of(1, 2, 3, 4, 5).toArray();
        IntStream range = IntStream.range(1, 5);

        long[] longs = LongStream.of(1, 2, 3, 4, 5).toArray();
        double[] doubles = DoubleStream.of(1, 2, 3, 4, 5).toArray();
        Object[] objects = Stream.of(1, 2, 3, 4, 5).toArray();


        // 각 단어의 빈도수를 계산하여 Map<String, Long>에 저장
        Map<String, Long> freq = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(freq);


        List<String> topTwo = freq.keySet().stream()
                .sorted(Comparator.comparing(freq::get).reversed())
                .limit(2)
                .toList();


        // Enum -> Map 변환
        Map<String, Operation> stringToNum =
                Stream
                        .of(Operation.values())
                        .collect(Collectors.toMap(Object::toString, e -> e));


        // 중간 연산: filter와 map
        // 종단 연산: collect
        List<String> filteredWords = words.stream() // Stream<String> 생성
                .filter(s -> s.startsWith("a")) // "J"로 시작하는 단어 필터링
                .map(String::toUpperCase) // 모든 문자를 대문자로 변환
                .collect(Collectors.toList()); // 결과를 List로 수집

        System.out.println(filteredWords); // 출력: [JAVA]

        // 종단 연산: forEach
        filteredWords.forEach(System.out::println); // JAVA를 출력
    }

    @Test
    void toMap(){
        List<Member> people = Arrays.asList(
                new Member("John", 30),
                new Member("Sara", 25));

        Map<String, Integer> nameToAgeMap = people.stream()
                .collect(Collectors.toMap(Member::getName, Member::getAge));

        System.out.println(nameToAgeMap);



        List<Member> people2 = Arrays.asList(
                new Member("John", 30),
                new Member("Sara", 25),
                new Member("John", 22) // 동일 이름, 다른 나이
        );

        Map<String, Integer> nameToAgeMap2 = people2.stream()
                .collect(Collectors.toMap(
                        Member::getName,
                        Member::getAge,
                        BinaryOperator.maxBy(Comparator.naturalOrder()))); // 충돌 시 나이가 더 적은 것을 선택

        System.out.println(nameToAgeMap2);
    }

    @Test
    void toGroupingBy(){
        List<Member> members = Arrays.asList(
                new Member("John", 20),
                new Member("Sara", 30),
                new Member("Paul", 20),
                new Member("Emma", 30)
        );

        Map<Integer, Double> collect = members.stream()
                .collect(Collectors.groupingBy(Member::getAge, Collectors.averagingInt(Member::getAge)));

        System.out.println(collect);
    }

    @Test
    void parallelTest(){
        int[] numbers = IntStream.range(0, 1000000000).toArray();
        long startTime = System.currentTimeMillis();
        long count = Arrays.stream(numbers).
                parallel()
                .filter(n -> n % 2 == 0)
                .count();
        long endTime = System.currentTimeMillis();

        System.out.println("Even numbers count: " + count);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

}
