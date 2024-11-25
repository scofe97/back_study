package org.example.chapter10;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class TestMain10_2 {
    public static void main(String[] args) {

        Path path1 = Paths.get("test1.txt");
        Path path2 = Paths.get("test2.txt");
        Path path3 = Paths.get("test3.txt");

        ThrowingFunction<Path, String> throwingFn = Files::readString;

        Stream.of(path1, path2, path3)
                .map(ThrowingFunction.uncheck(Files::readString)) // 예외처리가 안된다.
                .forEach(System.out::println);
    }
}
