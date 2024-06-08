package collection.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        // List 생성
        List<String> list = new ArrayList<>();

        // add(E e): 리스트의 끝에 지정된 요소를 추가합니다.
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("After add: " + list);

        list.add(1, "Mango");

        List<String> anotherList = List.of("Peach", "Grapes");
        list.addAll(anotherList);
        System.out.println("list = " + list);

        List<String> anotherList2 = List.of("Orange", "Grapes");
        list.addAll(2, anotherList2);
        System.out.println("list = " + list);

        list.set(3, "Kiwi");

        String isRemove1 = list.remove(4);
        System.out.println("isRemove1 = " + isRemove1);

        boolean isRemove2 = list.remove("Banana");
        System.out.println("isRemove2 = " + isRemove2);

        boolean contains = list.contains("Cherry");
        System.out.println("contains = " + contains);

        list.sort(null);
        list.sort(Comparator.naturalOrder());
        List<String> subList = list.subList(1, 3);
        System.out.println("subList = " + subList);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("next = " + next);
        }
    }
}
