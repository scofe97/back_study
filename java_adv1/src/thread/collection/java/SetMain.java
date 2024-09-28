package thread.collection.java;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> list = new CopyOnWriteArraySet<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list = " + list);

        // 순서 유지
        Set<Integer> skipListSet = new ConcurrentSkipListSet<>();
        skipListSet.add(3);
        skipListSet.add(2);
        skipListSet.add(1);
        System.out.println("skipListSet = " + skipListSet);

    }
}
