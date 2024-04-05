package com.example.quarts;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JavaSchedulerTest {

    @Test
    void timer() throws InterruptedException {
        Timer timer1 = new Timer();
        Timer timer2 = new Timer();
        Timer timer3 = new Timer();
        Timer timer4 = new Timer();
        TimerTask task1 = new TimerTask() {
            // 실행하는 작업
            @Override
            public void run() {
                System.out.println("작업1 수행!");
            }
        };

        TimerTask task2 = new TimerTask() {
            // 실행하는 작업
            @Override
            public void run() {
                System.out.println("작업2 수행!");
            }
        };

        TimerTask task3 = new TimerTask() {
            // 실행하는 작업
            @Override
            public void run() {
                System.out.println("작업3 수행!");
            }
        };

        TimerTask task4 = new TimerTask() {
            // 실행하는 작업
            @Override
            public void run() {
                System.out.println("작업4 수행!");
            }
        };

        // 5초 후에 작업 수행
        timer1.schedule(task1, 5000);

        // 5초 후에 첫 작업을 수행하고, 이후 2초마다 반복
        timer2.schedule(task2, 5000, 2000);

        // 현재 시간으로부터 5초 후의 시간 설정
        Date time = new Date(System.currentTimeMillis() + 5000);
        timer3.schedule(task3, time);

        // 현재 시간으로부터 5초 후의 시간 설정
        Date firstTime = new Date(System.currentTimeMillis() + 5000);
        timer4.schedule(task4, firstTime, 2000); // 첫 작업 수행 시간과 이후 2초마다 반복

        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    void scheduler() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("작업 실행!");

        // 5초 후에 작업 실행
        executor.schedule(task, 5, TimeUnit.SECONDS);

        // 첫 작업 실행 후, 2초 간격으로 반복 실행
        executor.scheduleAtFixedRate(task, 5, 2, TimeUnit.SECONDS);

        // 첫 작업 실행 후, 이전 작업 완료 후 2초 간격으로 반복 실행
        executor.scheduleWithFixedDelay(task, 5, 2, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(10);
        executor.shutdown();
    }
}