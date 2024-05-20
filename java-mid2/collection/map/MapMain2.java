package org.example.collection.map;

import java.util.HashMap;

public class MapMain2 {

    public static void main(String[] args) {
        HashMap<String, Integer> studentMap = new HashMap<>();

        studentMap.put("studentA", 90);
        System.out.println("studentMap = " + studentMap);

        studentMap.put("studentA", 100);
        System.out.println("studentMap = " + studentMap);

        boolean studentA = studentMap.containsKey("studentA");
        System.out.println("studentA = " + studentA);

        studentMap.remove("studentA");
        System.out.println("studentMap = " + studentMap);


    }
}
