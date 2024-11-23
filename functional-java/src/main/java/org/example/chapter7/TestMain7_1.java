package org.example.chapter7;

import java.util.stream.IntStream;

public class TestMain7_1 {

    public static void main(String[] args) {
        IntStream.iterate(1, idx -> idx+1)
                .limit(4L)
                .forEachOrdered(System.out::println);

        IntStream.iterate(1, idx -> idx < 5,idx -> idx+1).forEachOrdered(System.out::println);
        IntStream.iterate(1, idx -> idx < 5,idx -> idx+1).forEach(System.out::println);
    }
}
