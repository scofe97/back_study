package set.javaset;

import java.util.*;

public class JavaSetMain2 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // add(E e) - 지정된 요소를 세트에 추가
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        System.out.println("Set after add: " + set);

        // addAll(Collection c) - 합집합
        Set<String> otherSet = Set.of("Durian", "ElderBerry");
        set.addAll(otherSet);
        System.out.println("set = " + set);

        // continas(Object o) - 포함여부
        boolean contains = set.contains("Apple");
        boolean containsAll = set.containsAll(otherSet);

        // remove(Object o) - 제거
        set.remove("banana");
        set.removeAll(otherSet);

        // retainAll - 교집합
        set.add("Fig");
        Set<String> retainSet = Set.of("Apple", "Fig");
        set.retainAll(retainSet);
        System.out.println("set = " + set);

        // toArray(T a) - 세트의 모든 요소를 지정된 배열로 반환
        String[] stringArray = new String[set.size()];
        set.toArray(stringArray);
        System.out.print("Set elements as String array: ");
        for (String element : stringArray) {
            System.out.print(element + " ");
        }
    }
}
