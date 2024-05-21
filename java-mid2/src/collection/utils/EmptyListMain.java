package collection.utils;

import java.util.*;

public class EmptyListMain {
    public static void main(String[] args) {
        // 빈 가변 리스트
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        List<Object> list3 = Collections.emptyList();
        List<Object> list4 = List.of();

        System.out.println("list3.getClass() = " + list3.getClass());
        System.out.println("list4.getClass() = " + list4.getClass());

        List<Integer> list5 = Arrays.asList(1, 2, 3);
        List<Integer> list6 = List.of(1, 2, 3);

        Integer[] arr = {1, 2, 3, 4, 5, 6};
        List<Integer> list = Arrays.asList(arr);
        List<Integer> arr1 = List.of(arr);
        List<Integer> arr2 = new ArrayList<>(List.of(arr));
        List<Integer> arr3 = Arrays.stream(arr).toList(); // 불변

        System.out.println("arr2 = " + arr2);

    }
}
