package org.example.chapter10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestMain10_1 {
    public static void main(String[] args) {

        Path path1 = Paths.get("test1.txt");
        Path path2 = Paths.get("test2.txt");
        Path path3 = Paths.get("test3.txt");

        Stream.of(path1, path2, path3)
                .map(TestMain10_1::safeReadString) // 예외처리가 안된다.
                .forEach(System.out::println);
    }

    public static String safeReadString(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException exception) {
            return null;
        }
    }
}
