package org.example.chapter3;

public class Member implements Comparable<Member> {

    private Long id;
    private String name;
    private int age;

    public Member(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Member(String name, int age) {
        this.id = 0L;
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
        int result = Long.compare(this.id, o.id);

        if(result == 0){
            result = CharSequence.compare(this.name, o.name);
            if(result == 0 ){
                result = Integer.compare(this.age, o.age);
            }
        }
        return result;
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
