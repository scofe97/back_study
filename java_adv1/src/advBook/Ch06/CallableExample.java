package advBook.Ch06;

import java.util.concurrent.Callable;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        var o = new Object();
        Callable<String> callable = o::toString;

        System.out.println("callable.call() = " + callable.call());

    }
}
