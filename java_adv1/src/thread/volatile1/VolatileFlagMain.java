package thread.volatile1;

import static thread.util.MyLogger.log;

public class VolatileFlagMain {

    public static void main(String[] args) {

    }

    static class MyTask implements Runnable {
        boolean runFlag = true;

        @Override
        public void run() {
            log("");
        }
    }
}
