package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static thread.executor.ExecutorUtils.printState;
import static thread.util.ThreadUtils.sleep;

public class PreStartPoolMain {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(1000);
        printState(es);
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) es;
        poolExecutor.prestartAllCoreThreads(); // 스레드 미디 만듬
        sleep(100);
        printState(es);
    }
}