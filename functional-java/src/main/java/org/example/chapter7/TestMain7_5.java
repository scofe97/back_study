package org.example.chapter7;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestMain7_5 {

    public static void main(String[] args) {


        // 30개의 User 객체 생성
        List<User> users = IntStream.range(0, 30)
                .mapToObj(i -> new User(
                        UUID.randomUUID(), // UUID
                        "Group-" + (i % 5), // 그룹 이름 (5개의 그룹으로 나눔)
                        LocalDateTime.now().minusDays(i), // 로그인 날짜 (최근 날짜에서 i일 전)
                        List.of("Log-" + i + "-1", "Log-" + i + "-2") // 로그 엔트리 2개 추가
                ))
                .toList();

        Map<String, List<User>> lookUp = users.stream()
                .collect(Collectors.groupingBy(User::group));

        // 다운 스트림 변경으로 Set 타입으로 받기
        Collector<UUID, ?, Set<UUID>> collectToSet = Collectors.toSet();
        Collector<User, ?, Set<UUID>> mapToId = Collectors.mapping(User::id, collectToSet);

        Collector<User, ?, Map<String, Set<UUID>>> userMapCollector = Collectors.groupingBy(User::group, mapToId);
    }
}
