package collection.compare;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortMain4 {
    public static void main(String[] args) {
        collection.compare.MyUser myUser1 = new collection.compare.MyUser("a", 30);
        collection.compare.MyUser myUser2 = new collection.compare.MyUser("b", 20);
        collection.compare.MyUser myUser3 = new collection.compare.MyUser("c", 10);

        List<collection.compare.MyUser> list = new LinkedList<>();
        list.add(myUser1);
        list.add(myUser2);
        list.add(myUser3);
        System.out.println("기본 데이터");
        System.out.println(list);

        System.out.println("Comparable 기본 정렬");
        list.sort(null);
        System.out.println(list);

        System.out.println("IdComparator 정렬");
        list.sort(new collection.compare.IdComparator());
        System.out.println(list);

        Collections.sort(list);

    }
}
