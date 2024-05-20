package org.example.collection.iterable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class JavaIterableMain {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> listIter = list.iterator();
        while (listIter.hasNext()) {
            System.out.println(listIter.next());
        }
        printAll(list.iterator());


        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator<Integer> setIter = set.iterator();
        while (setIter.hasNext()) {
            System.out.println(setIter.next());
        }
        printAll(set.iterator());
    }

    private static void printAll(Iterator<Integer> iterator) {
        System.out.println("iterator = " + iterator);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void forEach(Iterable<Integer> iterable) {
        System.out.println("iterable = " + iterable.getClass());
        for (Integer integer : iterable) {
            System.out.println(integer);
        }
    }
}
