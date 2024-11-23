package org.example.chapter3;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestMain4 {

    public static void main(String[] args) {

        // 단일 문자열 함수
        Function<String, String> removeLowerCaseA = str -> str.replace("a", "");
        Function<String, String> upperCase = String::toUpperCase;

        // 합성된 문자열 함수
        Function<String, String> stringOperations = removeLowerCaseA.andThen(upperCase);

        Consumer<String> task = Compositor.compose(stringOperations, System.out::println);
        task.accept("atesta");
    }
}
