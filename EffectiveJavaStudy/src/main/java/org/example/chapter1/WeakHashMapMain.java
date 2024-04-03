package org.example.chapter1;

import java.util.WeakHashMap;

public class WeakHashMapMain {
    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();

        Object key = new Object();
        weakHashMap.put(key, "example");

        // 키에 대한 강한 참조 존재
        System.out.println("Before nullifying key: " + weakHashMap.containsKey(key)); // true

        key = null;
        System.gc();
        Thread.sleep(1000);

        System.out.println("After nullifying key and GC: " + weakHashMap.isEmpty()); // true
    }
}
