package ch05;

public class HappensBeforeExample {
    private static boolean ready;
    private static int number;

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
            number = 42;
            ready = true;
        });

        Thread readerThread = new Thread(() -> {
            if (ready) {
                System.out.println(number); // 42가 출력될 것으로 기대됨.
            }
        });

        writerThread.start();
        writerThread.join();

        // writerThread가 끝나야 readerThread가 실행됨
        readerThread.start();
        readerThread.join();
    }
}
