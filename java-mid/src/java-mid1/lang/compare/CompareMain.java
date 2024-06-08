package lang.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareMain {

    public static void main(String[] args) {
        Member member1 = new Member(1L, "Alice", 30);
        Member member2 = new Member(2L, "Bob", 25);
        Member member3 = new Member(3L, "Charlie", 35);
        Member member4 = new Member(4L, "Diana", 28);
        Member member5 = new Member(5L, "Ethan", 40);

        List<Member> members = new ArrayList<>(List.of(member1, member2, member3, member4, member5));

        // 1. Collections.sort()
        Collections.sort(members);
        System.out.println("1. Collections.sort()");
        extracted(members);

        // 2, List.sort()
        members.sort(null); // Comparable 존재한다면 Null 사용해도됨

        members.sort(Comparator.comparing(Member::getAge)); // 람다 메서드

        members.sort(new Comparator<Member>() { // 익명 클래스
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("2. List.sort()");
        extracted(members);



    }

    private static void extracted(List<Member> members) {
        for (Member member : members) {
            System.out.println("member = " + member);
        }
    }
}
