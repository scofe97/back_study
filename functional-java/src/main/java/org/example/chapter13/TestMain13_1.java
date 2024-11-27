package org.example.chapter13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestMain13_1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        var executor = Executors.newFixedThreadPool(10);

        Callable<Integer> expensiveTask = () -> {
            System.out.println("task start");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("task done");
            return 42;
        };

        System.out.println("(main) before submitting the task");
        var future = executor.submit(expensiveTask); // 계산시작
        System.out.println("main after submitting the task");

        var theAnswer = future.get(); // 완료전까지 스레드 멈춤
        System.out.println("theAnswer = " + theAnswer);
    }
}
