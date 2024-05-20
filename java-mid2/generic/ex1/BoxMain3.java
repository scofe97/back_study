package org.example.generic.ex1;

public class BoxMain3 {

    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<>(); // 생성 시점에 T의 타입 결정
        integerBox.setValue(10);
        // integerBox.setValue("문자 100"); // Integer 타입만 허용!!
        Integer integer = integerBox.getValue();
        System.out.println("integer = " + integer);

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.setValue("Hello");
        String str = stringBox.getValue();
        System.out.println("str = " + str);
    }
}
