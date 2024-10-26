package ch05;

public class Counter {
    private int count = 0;

    // 동기화된 쓰기 메서드
    public synchronized void increment() {
        count++;
    }

    // 동기화되지 않은 읽기 메서드
    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread reader = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println("Count: " + counter.getCount());
            }
        });

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();
    }
}
