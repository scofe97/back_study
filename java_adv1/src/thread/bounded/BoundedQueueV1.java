package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static thread.util.MyLogger.log;

public class BoundedQueueV1 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV1(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        if (queue.size() == max) {// t1: 9/10, t2: 9/10
            log("[put] 큐가 가득참, 버림 " + data);
            return;
        }

        // t1: 10/10,  t2: 11/10 (문제 발생);
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        if (queue.isEmpty()) {
            return null;
        }

        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
