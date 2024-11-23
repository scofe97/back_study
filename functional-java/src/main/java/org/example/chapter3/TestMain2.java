package org.example.chapter3;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class TestMain2 {

    public static void main(String[] args) {

        Function<String, String> removeLowerCaseA = str -> str.replace("a", "");
        Function<String, String> upperCase = String::toUpperCase;

        var input = "abcd";

        removeLowerCaseA.andThen(upperCase)
                .apply(input);

        upperCase.compose(removeLowerCaseA)
                .apply(input);

    }
}
