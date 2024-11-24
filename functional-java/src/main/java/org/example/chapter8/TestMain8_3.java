package org.example.chapter8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain8_3 {

    public static void main(String[] args) {
        Integer total = Stream.of(1, 2, 3, 4, 5, 6)
                .parallel()
                .reduce(0, Integer::sum);
    }
}
