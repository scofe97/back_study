package set;

import java.util.Arrays;

public class HashStart2 {
    public static void main(String[] args) {
        // 입력: 1, 2, 5, 8

        Integer[] inputArray = new Integer[10];
        inputArray[1] = 1;
        inputArray[2] = 2;
        inputArray[5] = 5;
        inputArray[8] = 8;
        System.out.println("Arrays.toString(inputArray) = " + Arrays.toString(inputArray));

        int searchValue = 8;
        Integer result = inputArray[searchValue];
        System.out.println("result = " + result);
    }
}