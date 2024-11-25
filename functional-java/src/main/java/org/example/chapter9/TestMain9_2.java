package org.example.chapter9;

public class TestMain9_2 {

    public static void main(String[] args) {

        String name = null;

        // String lowerCase = name.toLowerCase(); // NullPointerException
        boolean notString = name instanceof String; // false
        boolean stillNotString = ((String) name) instanceof String; // false

    }
}
