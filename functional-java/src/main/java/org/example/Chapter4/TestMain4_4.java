package org.example.Chapter4;

import java.util.ArrayList;
import java.util.List;

public class TestMain4_4 {

    public static void main(String[] args) {

        final List<String> fruits = new ArrayList<>();
        System.out.println(fruits.isEmpty());

        fruits.add("Apple");
        System.out.println(fruits.isEmpty());

        // 재할당 금지
        //fruits = List.of("Mango", "Melon");
    }
}
