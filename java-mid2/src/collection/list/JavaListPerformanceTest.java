
package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaListPerformanceTest {
    public static void main(String[] args) {
        int size = 100_000;
        int loop = 10_000;

        System.out.println("===ArrayList 추가===");
        addFirst(new ArrayList<>(), size);
        addMid(new ArrayList<>(), size);
        ArrayList<Integer> arrayList = new ArrayList<>();
        addLast(arrayList, size);

        System.out.println("===ArrayList 조회===");
        getIndex(arrayList, loop, 0);
        getIndex(arrayList, loop, size /2);
        getIndex(arrayList, loop, size -1);

        System.out.println("===ArrayList 검색===");
        search(arrayList, loop, 0);
        search(arrayList, loop, size /2);
        search(arrayList, loop, size -1);



        System.out.println("===LinkedList 추가===");
        addFirst(new LinkedList<>(), size);
        addMid(new LinkedList<>(), size);
        LinkedList<Integer> linkedList = new LinkedList<>();
        addLast(linkedList, size);

        System.out.println("===LinkedList 조회===");
        getIndex(linkedList, loop, 0);
        getIndex(linkedList, loop, size /2);
        getIndex(linkedList, loop, size -1);

        System.out.println("===LinkedList 검색===");
        search(linkedList, loop, 0);
        search(linkedList, loop, size /2);
        search(linkedList, loop, size -1);



        List<Integer> immutableList = createImmutableList(size);
        System.out.println("===List.of 조회===");
        getIndex(immutableList, loop, 0);
        getIndex(immutableList, loop, size / 2);
        getIndex(immutableList, loop, size - 1);

        System.out.println("===List.of 검색===");
        search(immutableList, loop, 0);
        search(immutableList, loop, size / 2);
        search(immutableList, loop, size - 1);
    }

    private static List<Integer> createImmutableList(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return List.of(array);
    }

    private static void addFirst(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("앞에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void addMid(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i / 2, i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("중간에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void addLast(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("뒤에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    // loop 만큼 index 조회
    private static void getIndex(List<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("index: " + index + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    // loop 만큼 findValue 검색
    private static void search(List<Integer> list, int loop, int findValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.indexOf(findValue);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("findValue: " + findValue + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
    }
}
