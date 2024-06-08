package collection.array;

public class MyArrayListV3Main {

    public static void main(String[] args) {
        collection.array.MyArrayListV3 list = new collection.array.MyArrayListV3();

        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);

        System.out.println("addLast");
        list.add(3, "addList");
        System.out.println(list);

        System.out.println("addFirst");
        list.add(0, "addFirst");
        System.out.println(list);

        Object remove1 = list.remove(4);
        System.out.println("removed(4) = " + remove1);
        System.out.println(list);

        Object remove2 = list.remove(0);
        System.out.println("remove(0)=" + remove2);
        System.out.println(list);
    }
}
