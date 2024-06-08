package collection.iterable;

import java.util.Iterator;

public class MyArrayMain {

    public static void main(String[] args) {
        collection.iterable.MyArray myArray = new collection.iterable.MyArray(new int[]{1, 2, 3, 4,});

        Iterator<Integer> iterator = myArray.iterator();
        System.out.println("iterator 사용");
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println("next = " + next);
        }

        System.out.println("for-each 추가");
        for (Integer value : myArray) {
            System.out.println("value = " + value);
        }

        // 컴파일
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println("value = " + value);
        }
    }
}
