package set.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class UniqueNamesTest2 {

    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        TreeSet<Integer> set = new TreeSet<>(List.of(inputArr));

        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list2 = List.of(1, 2, 3); // Java 9이상 권장

//        for (Integer s : inputArr) {
//            set.add(s);
//        }

        for (Integer s : set) {
            System.out.println(s);
        }
    }
}
