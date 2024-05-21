package collection.compare;

import java.util.Arrays;

public class SortMain3 {
    public static void main(String[] args) {
        collection.compare.MyUser myUser1 = new collection.compare.MyUser("a", 30);
        collection.compare.MyUser myUser2 = new collection.compare.MyUser("b", 20);
        collection.compare.MyUser myUser3 = new collection.compare.MyUser("c", 10);

        collection.compare.MyUser[] array = {myUser1, myUser2, myUser3};
        System.out.println("기본 데이터");
        System.out.println(Arrays.toString(array));

        System.out.println("Comparable 기본 정렬");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        // 추가
        System.out.println("IdComparator 정렬");
        Arrays.sort(array, new collection.compare.IdComparator());
        System.out.println(Arrays.toString(array));

        System.out.println("IdComparator().reversed()");
        Arrays.sort(array, new collection.compare.IdComparator().reversed());
        System.out.println(Arrays.toString(array));
    }
}
