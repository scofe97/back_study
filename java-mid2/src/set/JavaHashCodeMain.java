package set;

import set.member.Member;

public class JavaHashCodeMain {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println("obj1.hashCode() = " + obj1.hashCode());
        System.out.println("obj2.hashCode() = " + obj2.hashCode());
        System.out.println(Integer.toHexString(obj1.hashCode()));

        Integer i = 10;
        String strA = "A";
        String strAB = "AB";

        System.out.println("10.hashCode() = " + i.hashCode());
        System.out.println("A.hashCode() = " + strA.hashCode());
        System.out.println("AB.hashCode() = " + strAB.hashCode());

        // hashCode는 마이너스 값이 들어올 수 있다.
        System.out.println("-1.hashCode() = " + Integer.valueOf(-1).hashCode());

        // 둘은 같은가? (인스턴스는 다르지만 equals는 같다.)
        Member member1 = new Member("idA");
        Member member2 = new Member("idA");

        // equals, hashCode 오버라이딩 하지 않은 경우
        System.out.println("(member1 == member2) = " + (member1 == member2));
        System.out.println("(member1 equals member2) = " + (member1.equals(member2)));
        System.out.println("(member1.hashCode() = " + member1.hashCode());
        System.out.println("(member2.hashCode() = " + member2.hashCode());

    }
}
