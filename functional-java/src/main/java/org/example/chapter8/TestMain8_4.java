package org.example.chapter8;

import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.function.IntUnaryOperator;
import java.util.stream.Stream;

public class TestMain8_4 {

    public static void main(String[] args) {
        var elementCount = 100_000_000;

        IntUnaryOperator multiplyByTwo = in -> in * 2;

        var rnd = new Random();

        IntSummaryStatistics loopStats = new IntSummaryStatistics();
        for (int idx = 0; idx < elementCount; idx++) {
            var value = rnd.nextInt();
            var subResult = multiplyByTwo.applyAsInt(value);
            var finalResult = multiplyByTwo.applyAsInt(subResult);
            loopStats.accept(finalResult);
        }

        var seqStats = rnd.ints(elementCount)
                .map(multiplyByTwo)
                .map(multiplyByTwo)
                .summaryStatistics();

        var parallelStats = rnd.ints(elementCount)
                .parallel()
                .map(multiplyByTwo)
                .map(multiplyByTwo)
                .summaryStatistics();
    }
}
