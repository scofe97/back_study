package org.example.Chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMain4_2 {

    public static void main(String[] args) {
        ArrayList<String> modifiable = new ArrayList<>();
        modifiable.add("blue");
        modifiable.add("red");

        // 수정 불가능(한다면 예외발생)
        List<String> unmodifiable = Collections.unmodifiableList(modifiable);
        //unmodifiable.clear();

        // 하지만 원본이 수정되는걸 피할수는 없음
        modifiable.add("green");
        System.out.println(unmodifiable.size());
    }
}
