package org.example.chapter1;

import java.util.Objects;
import java.util.function.Predicate;

interface HelloWorld {
    String sayHello(String name);
}

public class TestMai2 {
    public static void main(String[] args) {
        var nonEffectivelyFinal = 1_000L;

        nonEffectivelyFinal = 9_000L;

        var finalAgain = nonEffectivelyFinal;

        // nonEffectiveFinal은 사용불가
        Predicate<Long> isOver9000 = input -> input > finalAgain;


        new HelloWorld() {
            @Override
            public String sayHello(String name) {
                return "hello, " + name + "!";
            }
        };
    }

    HelloWorld helloWorldLama = name ->"hello, "+name +"!";
}
