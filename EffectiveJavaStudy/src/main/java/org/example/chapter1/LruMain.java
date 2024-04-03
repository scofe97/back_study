package org.example.chapter1;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruMain {

    public static void main(String[] args) {
        int capacity = 100;
        LinkedHashMap<Integer, Integer> lruCache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };

        for (int i = 0; i < 150; i++) {
            lruCache.put(i, i);
        }

        for (Integer i : lruCache.keySet()) {
            System.out.println("i = " + i); // 50부터 출력된다.
        }
    }
}
