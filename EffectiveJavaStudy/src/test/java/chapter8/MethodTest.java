package chapter8;

import org.junit.jupiter.api.Test;

import java.util.Objects;

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
}
