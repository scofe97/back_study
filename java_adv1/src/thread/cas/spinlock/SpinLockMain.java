package thread.cas.spinlock;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class SpinLockMain {
    public static void main(String[] args) {
        // SpinLockBad spinLockBad = new SpinLockBad();
        SpinLock spinLockBad = new SpinLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                spinLockBad.lock();

                try {
                    log("비즈니스 로직 실행");
                    sleep(10); // 오래 걸리는 작업에서 스핀 락 사용X
                } finally {
                    spinLockBad.unlock();

                }
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
