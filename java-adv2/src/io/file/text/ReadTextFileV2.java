package io.file.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV2 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("=== Write String ===");
        System.out.println(writeString);

        Path path = Path.of(PATH);

        // 파일에 쓰기
        Files.writeString(path, writeString, UTF_8);
        // 파일에서 읽기
        System.out.println("=== Read String ===");
        List<String> lines = Files.readAllLines(path, UTF_8);
        for (String line : lines) {
            System.out.println("line = " + line);
        }

        // Stream 방식
        // 파일 전체가 아닌 Stream 으로 1줄씩의 데이터만 자바로 불러온다.
        Stream<String> lineStream = Files.lines(path, UTF_8);
        lineStream.forEach(System.out::println);
        lineStream.close();
    }
}
