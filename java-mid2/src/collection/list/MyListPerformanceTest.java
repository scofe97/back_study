package collection.list;

public class MyListPerformanceTest {
    public static void main(String[] args) {
        int size = 50_000;
        System.out.println("===MyArrayList 추가===");
        addFirst(new collection.list.MyArrayList<>(), size);
        addMid(new collection.list.MyArrayList<>(), size);
        collection.list.MyArrayList<Integer> arrayList = new collection.list.MyArrayList<>();
        addLast(arrayList, size);

        int loop = 10_000;
        System.out.println("===MyArrayList 조회===");
        getIndex(arrayList, loop, 0);
        getIndex(arrayList, loop, size /2);
        getIndex(arrayList, loop, size -1);

        System.out.println("===MyArrayList 검색===");
        search(arrayList, loop, 0);
        search(arrayList, loop, size /2);
        search(arrayList, loop, size -1);

        System.out.println("===MyLinkedList 추가===");
        addFirst(new collection.list.MyLinkedList<>(), size);
        addMid(new collection.list.MyLinkedList<>(), size);
        collection.list.MyLinkedList<Integer> linkedList = new collection.list.MyLinkedList<>();
        addLast(linkedList, size);

        System.out.println("===MyLinkedList 조회===");
        getIndex(linkedList, loop, 0);
        getIndex(linkedList, loop, size /2);
        getIndex(linkedList, loop, size -1);

        System.out.println("===MyLinkedList 검색===");
        search(linkedList, loop, 0);
        search(linkedList, loop, size /2);
        search(linkedList, loop, size -1);
    }

    private static void addFirst(collection.list.MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("앞에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void addMid(collection.list.MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i / 2, i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("중간에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void addLast(collection.list.MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("뒤에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void getIndex(collection.list.MyList<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("index: " + index + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
    }

    private static void search(collection.list.MyList<Integer> list, int loop, int findValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.indexOf(findValue);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("findValue: " + findValue + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
    }
}
