package org.example.chapter14.decorator_oop;

public class MilkCarton {
    public Coffee pourInto(Coffee coffee) {
        System.out.println("MILK 넣기");
        return coffee;
    }
}
