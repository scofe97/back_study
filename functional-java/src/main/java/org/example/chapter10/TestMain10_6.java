package org.example.chapter10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class TestMain10_6 {
    public static void main(String[] args) {

        Path path1 = Paths.get("test1.txt");
        Path path2 = Paths.get("test2.txt");
        Path path3 = Paths.get("test3.txt");
        Path path4 = Paths.get("test4.txt"); // 해당 파일은 없음

        Stream.of(path1, path2, path3, path4)
                .map(TestMain10_6::safeReadString)
                .map(result -> result.map(String::toUpperCase, failure -> "IO Error"))
                .forEach(System.out::println);

        var result = safeReadString(path4)
                .map(success -> success.toUpperCase(), failure -> "IO-Error");
        System.out.println(result);


    }

    public static Result<String, IOException> safeReadString(Path path) {
        try {
            return Result.success(Files.readString(path));
        } catch (IOException exception) {
            return Result.failure(exception);
        }
    }
}
