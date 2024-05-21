package collection.link;

public class MyLinkedListV3Main {

    public static void main(String[] args) {
        collection.link.MyLinkedListV3<String> stringList = new collection.link.MyLinkedListV3<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        String string = stringList.get(0);
        System.out.println("string = " + string);

        collection.link.MyLinkedListV3<Integer> intList = new collection.link.MyLinkedListV3<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Integer integer = intList.get(0);
        System.out.println("integer = " + integer);
    }
}
