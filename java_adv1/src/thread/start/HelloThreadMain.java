package thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " start() 호출 전");
        helloThread.start(); // start()는 스레드를 실행하는 메서드
        System.out.println(Thread.currentThread().getName() + " start() 호출 후");

        System.out.println(Thread.currentThread().getName() + " main() end");
    }
}
