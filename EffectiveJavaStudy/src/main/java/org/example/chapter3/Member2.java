package org.example.chapter3;

import java.util.Comparator;

public class Member2 implements Comparable<Member2> {

    private static final Comparator<Member2> COMPARATOR =
            Comparator.comparingLong((Member2 m) -> m.id)
                    .thenComparing(m -> m.name)
                    .thenComparingInt(m -> m.age);

    private Long id;
    private String name;
    private int age;

    public Member2(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Member2 o) {
        return COMPARATOR.compare(this, o);
    }

    @Override
    public String toString() {
        return "Member2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
