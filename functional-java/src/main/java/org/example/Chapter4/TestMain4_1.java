package org.example.Chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMain4_1 {

    public static void main(String[] args) {

        String first = "hello, ";
        String second = "world";
        String result = first + second;

        ArrayList<Object> list = new ArrayList<>();
        List<Object> objects = Collections.unmodifiableList(list);
        objects.add(1);
    }
}
