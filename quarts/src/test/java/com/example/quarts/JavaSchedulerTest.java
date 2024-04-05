package com.example.quarts;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

public class JavaSchedulerTest {

    @Test
    void timer() throws InterruptedException {
        Timer timer1 = new Timer();
        Timer timer2 = new Timer();

        TimerTask task11 = new TimerTask() {
            // 실행하는 작업
            @Override
            public void run() {
                System.out.println("작업1-1 수행! " + Thread.currentThread());
            }
        };

        TimerTask task12 = new TimerTask() {
            // 실행하는 작업
            @Override
            public void run() {
                System.out.println("작업1-2 수행! " + Thread.currentThread());
            }
        };

        TimerTask task21 = new TimerTask() {
            // 실행하는 작업
            @Override
            public void run() {
                System.out.println("작업2-1 수행! " + Thread.currentThread());
            }
        };

        TimerTask task22 = new TimerTask() {
            // 실행하는 작업
            @Override
            public void run() {
                System.out.println("작업2-2 수행! " + Thread.currentThread());
            }
        };

        timer1.schedule(task11, 5000); // 5초 후에 작업 수행
        timer1.schedule(task12, 5000, 2000); // 5초 후에 첫 작업을 수행하고, 이후 2초마다 반복


        timer2.schedule(task21, 5000); // 5초 후에 작업 수행
        timer2.schedule(task22, 5000, 2000); // 첫 작업 수행 시간과 이후 2초마다 반복

        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    void scheduler() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        Runnable task1 = () -> {
            System.out.println("작업1 실행! " + Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("작업1 중단");
            }
        };
        Runnable task2 = () -> {
            System.out.println("작업2 실행! " + Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("작업2 중단");
            }
        };
        Runnable task3 = () -> {
            System.out.println("작업3 실행! " + Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("작업3 중단");
            }
        };

        // 5초 후에 작업 실행
        executor.schedule(task1, 5, TimeUnit.SECONDS);

        // 첫 작업 실행 후, 2초 간격으로 반복 실행
        executor.scheduleAtFixedRate(task2, 5, 2, TimeUnit.SECONDS);// 5 7 9 11

        // 첫 작업 실행 후, 이전 작업 완료 후 2초 간격으로 반복 실행
        executor.scheduleWithFixedDelay(task3, 5, 2, TimeUnit.SECONDS); // 56 89 1112

        TimeUnit.SECONDS.sleep(10);
        executor.shutdown();
    }
}