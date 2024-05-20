package set;

public class MyHashSetV0Main {

    public static void main(String[] args) {
        MyHashSetV0 set = new MyHashSetV0();
        set.add(1); // o(1)
        set.add(2); // o(n)
        set.add(3); // o(n)
        set.add(4); // o(n)
        set.add(5); // o(n)
        System.out.println(set);

        boolean result = set.add(4);
        System.out.println("중복 데이터 젖아 결과 = " + result);
        System.out.println(set);

        System.out.println("set.contain(3) = " + set.contain(3));
        System.out.println("set.contain(99) = " + set.contain(99));
    }
}
