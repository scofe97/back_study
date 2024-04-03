package chapter3;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UtilClassTest {
    @Test
    void test1(){
        List<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Elephant");
        animals.add("Cat");

        Collections.sort(animals, Comparator.comparingInt(String::length));
        System.out.println(animals); // [Dog, Cat, Elephant]

        Collections.sort(animals, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println(animals); // [Cat, Dog, Elephant]

        Collections.sort(animals, Comparator.comparingInt(String::length).reversed());
        System.out.println(animals); // [Elephant, Cat, Dog]
    }

    @Test
    void testCollectors(){
        // 리스트 수집
        Stream<String> names = Stream.of("John", "Paul", "George", "Ringo");
        List<String> nameList = names.collect(Collectors.toList());
        System.out.println(nameList);


        // 길이별 문자열 그룹화
        Stream<String> namesForGrouping = Stream.of("John", "Paul", "George", "Ringo");
        Map<Integer, List<String>> nameByLength = namesForGrouping.collect(Collectors.groupingBy(String::length));
        System.out.println(nameByLength);


        // 문자열 조인
        Stream<String> namesForJoin = Stream.of("John", "Paul", "George", "Ringo");
        String joinNames = namesForJoin.collect(Collectors.joining(", "));
        System.out.println(joinNames);
    }

    @Test
    void testOptional(){
        Optional<String> optionalPresent = Optional.of("Present");
        Optional<String> optionalEmpty = Optional.empty();

        // 값이 존재하는 경우 출력
        optionalPresent.ifPresent(name -> System.out.println("name = " + name));


        // 값이 없는 경우 기본값 설정
        String nameOrDefault = optionalEmpty.orElse("Default");
        System.out.println("nameOrDefault = " + nameOrDefault);


        // 값이 있으면 가져오고, 없으면 새로운 Optional 생성
        String value = optionalEmpty.orElseGet(() -> "New Value");
        System.out.println("Value or New Value: " + value);


        // 값이 없을 때 에러
        try {
            String valueOrThrow = optionalEmpty.orElseThrow(IllegalStateException::new);
            System.out.println(valueOrThrow);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testDateTime(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime specificDateTime = LocalDateTime.of(2020, 1, 1, 12, 0);
        System.out.println("specificDateTime = " + specificDateTime);

        LocalDateTime futureDateTime = now.plusDays(1).plusHours(2);
        System.out.println("futureDateTime = " + futureDateTime);
    }

    @Test
    void testZonedDate(){
        ZonedDateTime nowInSystemZone = ZonedDateTime.now();
        System.out.println("nowInSystemZone = " + nowInSystemZone);


        ZonedDateTime nowInParis = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("nowInParis = " + nowInParis);

        ZonedDateTime nowInTokyo = nowInParis.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("nowInTokyo = " + nowInTokyo);
    }

    @Test
    void testSystem(){
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        String path = System.getenv("PATH");
        System.out.println("path = " + path);

        String property = System.getProperty("java.version");
        System.out.println("property = " + property);

        System.gc();

        System.out.println("Hello World");

        System.err.println("This is an error message");
    }
}
