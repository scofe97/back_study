package collection.compare;

import java.util.TreeSet;

public class SortMain5 {
    public static void main(String[] args) {
        collection.compare.MyUser myUser1 = new collection.compare.MyUser("a", 30);
        collection.compare.MyUser myUser2 = new collection.compare.MyUser("b", 20);
        collection.compare.MyUser myUser3 = new collection.compare.MyUser("c", 10);

        TreeSet<collection.compare.MyUser> treeSet1 = new TreeSet<>();
        treeSet1.add(myUser1);
        treeSet1.add(myUser2);
        treeSet1.add(myUser3);
        System.out.println("Comparable 기본 정렬");
        System.out.println(treeSet1);

        TreeSet<collection.compare.MyUser> treeSet2 = new TreeSet<>(new collection.compare.IdComparator());
        treeSet2.add(myUser1);
        treeSet2.add(myUser2);
        treeSet2.add(myUser3);
        System.out.println("IdComparator 기본 정렬");
        System.out.println(treeSet2);
    }
}
