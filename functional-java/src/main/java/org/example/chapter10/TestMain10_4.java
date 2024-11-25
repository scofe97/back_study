package org.example.chapter10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class TestMain10_4 {
    public static void main(String[] args) {

        Path path1 = Paths.get("test1.txt");
        Path path2 = Paths.get("test2.txt");
        Path path3 = Paths.get("test3.txt");
        Path path4 = Paths.get("test4.txt");

        Stream.of(path1, path2, path3)
                .map(TestMain10_4::safeReadString)
                .filter(Result::isSuccess)
                .forEach(System.out::println);
    }

    public static Result<String, IOException> safeReadString(Path path) {
        try {
            return Result.success(Files.readString(path));
        } catch (IOException exception) {
            return Result.failure(exception);
        }
    }
}
