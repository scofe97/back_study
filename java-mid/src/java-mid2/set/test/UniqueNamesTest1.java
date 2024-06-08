package set.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UniqueNamesTest1 {

    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        HashSet<Integer> set = new HashSet<>(List.of(inputArr));

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
