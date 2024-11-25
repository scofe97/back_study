package org.example.chapter9;

import java.util.Optional;

public class TestMain9_4 {

    public static void main(String[] args) {

        String hasValue = "Optionals are awesome!";
        String nullRef = null;

        Optional<String> maybeValue = Optional.ofNullable(hasValue);
        Optional<String> emptyOptional = Optional.ofNullable(nullRef);

        maybeValue.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("값이 없다!!!!")
        );

        emptyOptional.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("값이 없다!!!!")
        );
    }
}
