package collection.array;

public class MyArrayListV4Main {

    public static void main(String[] args) {
        collection.array.MyArrayListV4<String> stringList = new collection.array.MyArrayListV4<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        String string = stringList.get(0);
        System.out.println("string = " + string);

        collection.array.MyArrayListV4<Integer> intList = new collection.array.MyArrayListV4<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Integer integer = intList.get(0);
        System.out.println("integer = " + integer);
    }
}
