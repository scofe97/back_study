package org.example.chapter13;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestMain13_3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 42);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 23);

        // Function 2개를 조합해 함수결과 도출
        BiFunction<Integer, Integer, CompletableFuture<Integer>> task = (lhs, rhs) -> CompletableFuture.supplyAsync(() -> lhs + rhs);

        // thenCombine 2단계 모두 정상완료이후 BiFunction 적용
        CompletableFuture<Integer> combined = future1.thenCombine(future2, task)
                .thenCompose(Function.identity());

        Integer test = combined.get();
        System.out.println("test = " + test);
    }
}
