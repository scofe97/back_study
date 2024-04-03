package chapter8;

import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.*;

public class MethodTest {

    @Test
    void objectsTest(){
        String test = null;
        String test1 = Objects.requireNonNullElse(test, "test");
        System.out.println(test1);
    }

    @Test
    void assertTest(){
        int[] numbers = {1, 2, 3, 4, 5};
        int index = 5; // 잘못된 인덱스 값

        // 인덱스가 배열 범위 내에 있는지 단언
        assert index >= 0 && index < numbers.length : "인덱스가 배열 범위를 벗어났습니다: " + index;

        System.out.println(numbers[index]);
    }

    @Test
    void nullTest(){
        List emptyList = Collections.EMPTY_LIST;
        List<Object> objects = Collections.emptyList();
        Map<Object, Object> objectObjectMap = Collections.emptyMap();
        Set<Object> objects1 = Collections.emptySet();

        objects1.add(new Object());

        for (Object o : objects1) {
            System.out.println("o = " + o);
        }
    }

    @Test
    void optionalTest(){
        Optional<Object> empty = Optional.empty();
        Optional<String> optionalWithNonNull = Optional.of("Hello world");

        String nullString = "1234";
        Optional<String> optionalNullable = Optional.ofNullable(nullString);


        if(optionalNullable.isPresent()) System.out.println("test");
        optionalWithNonNull.ifPresent(System.out::println);

        String defaultValue = optionalNullable.orElse("Default Value");
        System.out.println("defaultValue = " + defaultValue);
        String defaultValue2 = optionalNullable.orElseGet(() -> "Default value ");
        System.out.println("defaultValue2 = " + defaultValue2);

        try {
            optionalNullable.orElseThrow(() -> new IllegalStateException());
            System.out.println("baby");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        Optional<String> longer = optionalNullable.filter((s -> s.length() > 5));
        longer.ifPresent(s -> System.out.println("Longer than 5 characters: " + s));
    }
}
