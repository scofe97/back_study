package org.example.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain6_5 {
    public static void main(String[] args) {

        var strings = List.of("a", "b", "c", "d", "e");

        var reduced = strings.stream()
                .reduce("", String::concat);

        var joiner = strings.stream()
                .collect(Collector.of(() -> new StringJoiner("")
                        , StringJoiner::add
                        , StringJoiner::merge
                        , StringJoiner::toString));

        var collectWithCollectors = strings.stream()
                .collect(Collectors.joining());
    }
}
