package org.example.chapter1;

import java.awt.*;
import java.util.Objects;
import java.util.function.Predicate;

public class TestMain {
    public static void main(String[] args) {
        int totalTreasure = 0;  // 1
        int newTreasuresFound = findTreasure(6);  // 2

        totalTreasure = totalTreasure + newTreasuresFound;  // 3

        if (totalTreasure > 10) {  // 4
            System.out.println("You have a lot of treasure!");  // 5
        } else {
            System.out.println("You should look for more treasure!");  // 5
        }


        Predicate<Integer> predicate = Objects::isNull;

        // 10보다 큰지 확인하는 Predicate
        Predicate<Integer> greaterThanTen = (num) -> num > 10;

        // 두 조건을 AND로 조합하여 10보다 크고 짝수인지 확인
        Predicate<Integer> isEvenAndGreaterThanTen = predicate.and(greaterThanTen);

        System.out.println(isEvenAndGreaterThanTen.test(8));  // false: 짝수지만 10보다 작음
        System.out.println(isEvenAndGreaterThanTen.test(12)); // true: 짝수이고 10보다 큼

        // NOT 조건으로 짝수가 아닌지 확인
        Predicate<Integer> isOdd = predicate.negate();
        System.out.println(isOdd.test(7));
    }

    public static int findTreasure(int attempts) {
        // 임의로 보물을 찾는 로직을 작성합니다.
        return attempts * 2;  // 예를 들어, 시도한 횟수에 따라 보물을 찾는 양을 두 배로 반환합니다.
    }
}
