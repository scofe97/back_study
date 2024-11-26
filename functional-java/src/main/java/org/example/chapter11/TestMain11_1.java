package org.example.chapter11;

import java.util.function.IntSupplier;

public class TestMain11_1 {
    public static void main(String[] args) {
        var result = add(() -> 5, () -> 1 / 0);
        System.out.println(result);
    }

    static int add(IntSupplier x, IntSupplier y) {
        int actualX = x.getAsInt();
        return actualX + actualX;
    }
}
