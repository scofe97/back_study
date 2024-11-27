package org.example.chapter12;

public class TestMain12_1 {
    public static void main(String[] args) {
        var resultHead = factorialHead(4L);
        System.out.println("result = " + resultHead);

        var resultTail = factorialTail(4L, 1L);
        System.out.println("result = " + resultTail);
    }

    static long factorialHead(long n) {
        if (n == 1L) {
            return 1L;
        }

        var nextN = n - 1L;

        return n * factorialHead(nextN);
    }

    static long factorialTail(long n, long accumulator) {
        if (n == 1L) {
            return accumulator;
        }

        var nextN = n - 1L;
        var nextAccumulator = n * accumulator;

        return factorialTail(nextN, nextAccumulator);
    }
}
