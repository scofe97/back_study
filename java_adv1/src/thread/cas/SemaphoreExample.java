package thread.cas;

import thread.executor.RunnableTask;

import java.util.concurrent.Semaphore;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class SemaphoreExample {
    private final Semaphore semaphore = new Semaphore(2);
    private int counter = 0;

    public void increment() {
        try {
            semaphore.acquire(); // 세마포어 획득
            counter++;
            log("카운터 증가: " + counter);
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
            log("세마포어 종료");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SemaphoreExample example = new SemaphoreExample();

        Thread t1 = new Thread(() -> {
            log( "t1 시작");
            example.increment();
            log("t1 완료");
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            log( "t2 시작");
            example.increment();
            log("t2 완료");
        }, "Thread-2");

        Thread t3 = new Thread(() -> {
            log( "t3 시작");
            example.increment();
            log("t3 완료");
        }, "Thread-3");

        Thread t4 = new Thread(() -> {
            log( "t4 시작");
            example.increment();
            log("t4 완료");
        }, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        log(example.semaphore.toString());
    }
}
