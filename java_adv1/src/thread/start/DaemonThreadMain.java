package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " main() start");
        DeamonThread deamonThread = new DeamonThread();
        deamonThread.setDaemon(true); // 데몬 스레드 여부
        deamonThread.start();
        System.out.println(Thread.currentThread().getName() + " main() end");
    }

    static class DeamonThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
}
