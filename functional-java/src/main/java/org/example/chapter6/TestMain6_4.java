package org.example.chapter6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class TestMain6_4 {
    public static void main(String[] args) {
        var fruits = Stream.of("apple", "orange", "banana")
                .reduce(new ArrayList<>(),
                        (acc, fruit) -> {
                            var list = new ArrayList<>(acc);
                            list.add(fruit);
                            return list;
                        },
                        (lhs, rhs) -> {
                            var list = new ArrayList<>(lhs);
                            list.addAll(rhs);
                            return list;
                        });

        System.out.println(fruits);

    }
}
