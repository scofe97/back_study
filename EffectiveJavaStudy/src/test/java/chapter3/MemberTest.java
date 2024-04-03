package chapter3;

import org.example.chapter3.Member;
import org.example.chapter3.Member2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertSame;

class MemberTest {

    @Test
    void test() {
        Member member1 = new Member(3L, "John", 25);
        Member member2 = new Member(1L, "Alex", 30);
        Member member3 = new Member(2L, "Carl", 20);
        Member member4 = new Member(3L, "John", 20);
        Member member5 = new Member(1L, "Alex", 25);

        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);
        Collections.sort(members);

        for (Member member : members) {
            System.out.println(member);
        }
    }

    @Test
    void test2(){
        Member2 Member21 = new Member2(3L, "John", 25);
        Member2 Member22 = new Member2(1L, "Alex", 30);
        Member2 Member23 = new Member2(2L, "Carl", 20);
        Member2 Member24 = new Member2(3L, "John", 20);
        Member2 Member25 = new Member2(1L, "Alex", 25);

        List<Member2> members = Arrays.asList(Member21, Member22, Member23, Member24, Member25);
        Collections.sort(members);

        for (Member2 member : members) {
            System.out.println(member);
        }
    }

    @Test
    void test3(){
        Objects.checkFromIndexSize(1, 5, 9);
    }
}
