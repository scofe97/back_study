package org.example.chapter9;

import javax.swing.text.html.Option;
import java.util.Optional;

public class TestMain9_3 {

    public static void main(String[] args) {

        String hasValue = "Optionals are awesome!";
        String nullRef = null;

        Optional<String> maybeValue = Optional.ofNullable(hasValue);
        Optional<String> emptyOptional = Optional.ofNullable(nullRef);

        Optional<String> mustHaveValue = Optional.of(hasValue);
        // Optional<String> emptyOptional = Optional.of(nullRef); // NullPointerException

        Optional<String> noValue = Optional.empty();
    }
}
