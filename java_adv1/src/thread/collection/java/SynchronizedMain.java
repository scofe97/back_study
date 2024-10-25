package thread.collection.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedMain {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>()); // 동기화 적용!
        list.add("data1");
        list.add("data2");
        list.add("data3");
        System.out.println(list.getClass());
        System.out.println("list = " + list);
    }
}
