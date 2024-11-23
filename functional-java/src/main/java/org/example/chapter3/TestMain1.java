package org.example.chapter3;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class TestMain1 {

    public static void main(String[] args) {

        // 함수 아리티(아리티 -> 함수가 받아들이는 피연산자 수)
        Function<String, String> greeterFn = name -> "Hello" + name;

        // UnaryOperation -> Function 호환성이 가능하다.
        UnaryOperator<String> unaryOp = String::toUpperCase;
        Function<String, String> func = String::toUpperCase;
    }
}
