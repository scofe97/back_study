package org.example.chapter7;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class TestMain7_4 {

    public static void main(String[] args) {

        String[] fruits = {"Banana", "Melon", "Orange"};

        String[] result = Arrays.stream(fruits)
                .filter(fruit -> fruit.contains("a"))
                .toArray(String[]::new);
    }
}
