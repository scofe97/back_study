package org.example.chapter8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain8_1 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        var location = Paths.get("war-and-peace.txt");

        // 구두점(, . ? !)을 제거하기 위한 정규식
        var punctuation = Pattern.compile("\\p{Punct}");
        // 공백기준 문자열 나누기 위한 정규식
        var whiteSpace = Pattern.compile("\\s+");
        // 단어를 확인하기 위한 정규식
        var words = Pattern.compile("\\w+");

        Map<String, Integer> wordCount = null;

        try {
            var content = Files.readString(location);

            wordCount = Stream.of(content)
                    // 구두점 정리
                    .map(punctuation::matcher)
                    .map(matcher -> matcher.replaceAll(""))

                    // 단어 분할
                    .map(whiteSpace::split)
                    .flatMap(Arrays::stream)
                    .filter(word -> words.matcher(word).matches())

                    // 집계
                    .map(String::toLowerCase)
                    .collect(Collectors.toMap(
                            Function.identity(), // 단어 자체가 키
                            word -> 1, // 초기값 1
                            Integer::sum)); // 동일한 키가 있는경우 더함
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("word count = " + wordCount);
        long endTime = System.currentTimeMillis();
        long durationTimeSec = endTime - startTime;
        System.out.println(durationTimeSec + "m/s");
    }
}
