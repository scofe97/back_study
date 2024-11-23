package org.example.chapter6;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class TestMain6_3 {
    public static void main(String[] args) {
        Integer reduceOnly = Stream.of("apple", "orange", "banana")
                .reduce(0,
                        (acc, str) -> acc + str.length(),
                        Integer::sum);

        int mapReduce = Stream.of("apple", "orange", "banana")
                .mapToInt(String::length)
                .reduce(0, (acc, length) -> acc + length);
    }

    public static Integer max(Collection<Integer> numbers) {

        // 1. 초기값
        int result = Integer.MAX_VALUE;

        // 2.누적함
        for (Integer number : numbers) {
            result = Math.max(result, number);
        }

        return result;
    }
}
