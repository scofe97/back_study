package org.example.Chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMain4_3 {

    public static void main(String[] args) {
        ArrayList<String> original = new ArrayList<>();
        original.add("1");
        original.add("2");

        List<String> copiedList = List.copyOf(original);

        original.add("3");

        System.out.println(original); // [1, 2, 3]
        System.out.println(copiedList); // [1, 2]

    }
}
