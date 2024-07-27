package thread.start;

public class HelloThread extends Thread {
    @Override
    public void run() {
        // 현재 코드를 실행중인 스레드 이름조회
        System.out.println(Thread.currentThread().getName() + ": run()");
    }
}
