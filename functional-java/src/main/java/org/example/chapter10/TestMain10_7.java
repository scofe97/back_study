package org.example.chapter10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class TestMain10_7 {
    public static void main(String[] args) {

        Path path1 = Paths.get("test1.txt");
        Path path2 = Paths.get("test2.txt");
        Path path3 = Paths.get("test3.txt");
        Path path4 = Paths.get("test4.txt"); // 해당 파일은 없음

        var pathStringTry = Try.<Path, String>of(Files::readString);

        var trySuccessFailure = Try.<Path, String>of(Files::readString)
                .success(String::toUpperCase)
                .failure(str -> null)
                .apply(path4);

        Function<Path, Optional<String>> fileLoader =
                Try.<Path, String>of(Files::readString)
                        .success(String::toUpperCase)
                        .failure(str -> null);

        List<String> fileContents = Stream.of(path1, path2, path3, path4)
                .map(fileLoader)
                .flatMap(Optional::stream)
                .toList();

        System.out.println(fileContents);
    }

    public static Result<String, IOException> safeReadString(Path path) {
        try {
            return Result.success(Files.readString(path));
        } catch (IOException exception) {
            return Result.failure(exception);
        }
    }
}
