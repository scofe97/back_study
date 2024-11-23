package org.example.chapter7;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestMain7_2 {

    public static void main(String[] args) {
        // 1000이 아닌 1029와 같은 1000을 넘어선 값이 나옴
        Stream.generate(new AtomicInteger()::incrementAndGet)
                .parallel()
                .limit(1_000L)
                .mapToInt(Integer::valueOf)
                .max()
                .ifPresent(System.out::println);
    }

    Stream<UUID> createStream(long count) {
        return Stream.generate(UUID::randomUUID).limit(count);
    }
}
