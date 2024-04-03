package nested.anonymous.ex0;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Ex2Main {

    public static void helloDice(){
        System.out.println("프로그램 시작");

        int randomValue = new Random().nextInt(6) + 1;
        System.out.println("주사위 = " + randomValue);

        System.out.println("프로그램  종료");
    }

    public static void helloSum(){
        System.out.println("프로그램 시작");

        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("프로그램  종료");
    }

    public static void hello(TestInterface testInterface){
        System.out.println("프로그램 시작");
        testInterface.play();
        System.out.println("프로그램 종료");
    }

    public static void helloRun(Runnable runnable){
        System.out.println("프로그램 시작");
        runnable.run();
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        helloDice();
        helloSum();
        hello(new TestInterface() {
            @Override
            public void play() {
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위 = " + randomValue);
            }
        });

        hello(new TestInterface() {
            @Override
            public void play() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("i = " + i);
                }
            }
        });

        helloRun(() -> {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
        });

        helloRun(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
            }
        });
    }
}
