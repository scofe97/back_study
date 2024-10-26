package advBook.Ch06;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {

        CompletableFuture<Long> fut = getNthPrime(1_000_000_000);

        fut.orTimeout(1, TimeUnit.MINUTES) // 1분 내로 완료되지 않으면 TimeoutException 발생
                .thenAccept(l -> System.out.println("l = " + l)) // 작업이 성공적으로 완료되면 결과 출력
                .exceptionally(e -> { // 예외 발생 시 처리
                    if (e instanceof TimeoutException) {
                        System.out.println("작업 취소");
                        fut.cancel(true);
                    } else {
                        System.err.println("작업 중 오류 발생: " + e.getMessage());
                    }
                    return null;
                });

        System.out.println("논블락 테스트");
    }

    private static CompletableFuture<Long> getNthPrime(int i) {
        var numF = new CompletableFuture<Long>();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                numF.complete((long) Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                System.err.println("Cancelling search");
                throw new CancellationException("interrupted");
            }
        }).start();

        return numF;
    }
}
