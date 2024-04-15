package org.example.chapter5;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericList {
    public static void main(String[] args) {
//        Object[] objectArray = new Long[1];
//        objectArray[0] = "타입이 달라 넣을 수 없다"; // 런타임에서 예외발생
//
//        List<Object> ol = new ArrayList<Long>(); // 호환되지 않는 타입이다.
//        ol.add("타입이 달라 넣을 수 없다");

//        List<Integer> numberList = new ArrayList<>();
//        sumOfGenericNumbers(numberList);  // 자식타입 허용 o
//        sumOfNumbers(numberList);  // 자식타입 허용 x
//        System.out.println("Number List: " + numberList);

        List<Object> objectList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        Integer intValue = 42;
        Double doubleValue = 3.14;

        // Integer 리스트에 Integer 추가
        addToList(integerList, intValue);

        // Number 리스트에 Integer 추가
        addToList(numberList, intValue);

        // Number 리스트에 Double 추가
        addToList(numberList, doubleValue);

        // Object 리스트에 Double 추가
        addToList(objectList, doubleValue);

        // Object 리스트에 Integer 추가
        addToList(objectList, intValue);

        System.out.println("Integer List: " + integerList);
        System.out.println("Number List: " + numberList);
        System.out.println("Object List: " + objectList);

    }

    public static double sumOfGenericNumbers(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static double sumOfNumbers(List<Number> numbers) {
        double sum = 0.0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static  <T> void addToGenericList(List<? super T> list, T item) {
        list.add(item);
    }

    public static  void addToList(List<Integer> list, Integer item) {
        list.add(item);
    }

    public static <T> void addToList(List<? super T> list, T element) {
        list.add(element);
    }
}
