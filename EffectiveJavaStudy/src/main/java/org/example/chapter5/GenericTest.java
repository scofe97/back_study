package org.example.chapter5;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
//        ArrayList strings = new ArrayList<>();
//        unsafeAdd(strings, 42);
//        String s = strings.get(0);
//
//        ArrayList<Object> object = new ArrayList<>();
//        unsafeAdd(object, 42);
//        String o = object.get(0);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
