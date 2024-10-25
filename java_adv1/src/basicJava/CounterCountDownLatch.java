package basicJava;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterCountDownLatch implements Runnable {

    private final CountDownLatch latch;
    private final int value;
    private final AtomicInteger count;

    public CounterCountDownLatch(CountDownLatch latch, int value, AtomicInteger counter) {
        this.latch = latch;
        this.value = value;
        this.count = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        count.addAndGet(value);
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        var latch = new CountDownLatch(5);
        var count = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            var r = new CounterCountDownLatch(latch, i, count);
            new Thread(r).start();
        }

        latch.await();  // 메인 스레드는 모든 스레드가 완료될 때까지 대기
        System.out.println("Total: " + count.get());
    }
}
