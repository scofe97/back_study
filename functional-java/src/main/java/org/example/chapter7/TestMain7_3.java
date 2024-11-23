package org.example.chapter7;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestMain7_3 {

    public static void main(String[] args) {
        Random random = new Random();

        // 무한 랜덤
        IntStream ints = random.ints();
        ints.limit(5).forEach(System.out::println);

        // 5 ~ 9 범위 숫자
        IntStream boundedRandom = random.ints(5, 10);
        boundedRandom.limit(5).forEach(System.out::println);
    }
}
