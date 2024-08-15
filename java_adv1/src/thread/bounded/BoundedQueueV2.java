package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class BoundedQueueV2 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV2(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() == max) {// t1: 9/10, t2: 9/10
            log("[put] 큐가 가득참, 생산자 대기");
            sleep(1000);
        }

        // t1: 10/10,  t2: 11/10 (문제 발생);
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[take] 큐가 비어 있음, 소비자 대기");
            sleep(1000);
        }

        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
