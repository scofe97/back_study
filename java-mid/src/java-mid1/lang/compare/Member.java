package lang.compare;

import java.util.Comparator;

public class Member implements Comparable<Member> {

    private Long id;
    private String name;
    private int age;

    private static final Comparator<Member> COMPARATOR =
            Comparator
                    .comparingLong((Member m) -> m.id)
                    .thenComparing(m -> m.name)
                    .thenComparingInt(m -> m.age);

    public Member(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Member o) {
//        int result = Long.compare(this.id, o.id); // Long compare
//
//        if(result == 0){
//            result = CharSequence.compare(this.name, o.name); // String compare
//            if(result == 0 ){
//                result = Integer.compare(this.age, o.age); // Integer compare
//            }
//        }
//        return 0;

        return COMPARATOR.compare(this, o);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
