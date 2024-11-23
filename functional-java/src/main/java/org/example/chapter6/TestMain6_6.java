package org.example.chapter6;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestMain6_6 {
    public static void main(String[] args) {

        Stream.of("apple", "orange", "banana", "pear", "banana")
                .filter(s -> s.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);


        // 출력없음(count 연산결과에 ppek, map이 영향없기 떄문)
        long count = Stream.of("apple", "orange", "banana", "pear", "banana")
                .filter(str -> str.contains("e"))
                .peek(str -> System.out.println("peek 1:  = " + str))
                .map(str -> {
                    System.out.println("map = " + str);
                    return str.toUpperCase();
                })
                .peek(str -> System.out.println("peek 2:  = " + str))
                .count();
    }
}
