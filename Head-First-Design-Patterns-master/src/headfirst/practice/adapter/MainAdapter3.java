package headfirst.practice.adapter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class MainAdapter3 {
    public static void main(String[] args) {

        // Enumeration (구버전 API) 을 요구하는 가정
        List<String> list = List.of("Apple", "Banana", "Cherry");
        Enumeration<String> enumeration = Collections.enumeration(list);

        while (enumeration.hasMoreElements()) {
            String element = enumeration.nextElement();
            System.out.println(element);
        }

        // Array -> List , 실제로는 내부적으로 고정 크기의 리스트를 반환해서 배열참조
        String[] array = { "Dog", "Cat", "Mouse" };
        List<String> listArray = Arrays.asList(array);
        System.out.println("listArray.size() = " + listArray.size());
    }
}
