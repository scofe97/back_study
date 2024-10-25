package basicJava;

import java.util.concurrent.atomic.AtomicReference;

class SharedObject {
    private String value;

    public SharedObject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SharedObject{" +
                "value='" + value + '\'' +
                '}';
    }
}

public class AtomicReferenceExample {
    // AtomicReference를 사용하여 객체 참조를 안전하게 관리
    private static final AtomicReference<SharedObject> sharedObjectRef = new AtomicReference<>();

    public static void main(String[] args) {
        // 초기 객체 설정
        SharedObject initialObject = new SharedObject("Initial Value");
        sharedObjectRef.set(initialObject);

        // 스레드 1: 객체의 값을 업데이트
        Thread thread1 = new Thread(() -> {
            SharedObject newObject = new SharedObject("Updated by Thread 1");
            sharedObjectRef.set(newObject);
            System.out.println("Thread 1 set new value: " + sharedObjectRef.get());
        });

        // 스레드 2: 객체의 값을 업데이트
        Thread thread2 = new Thread(() -> {
            SharedObject newObject = new SharedObject("Updated by Thread 2");
            sharedObjectRef.set(newObject);
            System.out.println("Thread 2 set new value: " + sharedObjectRef.get());
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 최종 객체 상태 출력
        System.out.println("Final value: " + sharedObjectRef.get());
    }
}