package org.example.lamda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {

    private static final String FILE_PATH = "war-and-peace.txt";

    private Pattern punctuation = Pattern.compile("\\p{Punct}");
    private Pattern whiteSpace = Pattern.compile("\\s+");
    private Pattern words = Pattern.compile("\\w+");

    public Map<String, Integer> benchmarkTestMain8_1() throws IOException {
        var location = Paths.get(FILE_PATH);

        var content = Files.readString(location);

        return Stream.of(content)
                .map(punctuation::matcher)
                .map(matcher -> matcher.replaceAll(""))
                .map(whiteSpace::split)
                .flatMap(Arrays::stream)
                .filter(word -> words.matcher(word).matches())
                .map(String::toLowerCase)
                .collect(Collectors.toMap(
                        Function.identity(),
                        word -> 1,
                        Integer::sum
                ));
    }

    public Map<String, Integer> benchmarkTestMain8_2() throws IOException {
        var location = Paths.get(FILE_PATH);

        try (Stream<String> stream = Files.lines(location)) {
            return stream.parallel()
                    .map(punctuation::matcher)
                    .map(matcher -> matcher.replaceAll(""))
                    .map(whiteSpace::split)
                    .flatMap(Arrays::stream)
                    .filter(word -> words.matcher(word).matches())
                    .map(String::toLowerCase)
                    .collect(Collectors.toConcurrentMap(
                            Function.identity(),
                            word -> 1,
                            Integer::sum
                    ));
        }
    }

}
