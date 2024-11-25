package org.example.chapter9;

import java.util.Optional;

public class TestMain9_7 {
    public static void main(String[] args) {
        String hasValue = "Optionals are awesome!";
        String nullRef = null;


        // 권장
        String value = Optional.ofNullable(hasValue).orElse("임시");

        // 비권장
        if (Optional.ofNullable(hasValue).isPresent()) {
            //..
        }
    }
}
