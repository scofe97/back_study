package org.example.chapter3;

public record Person(
    String name,
    int age,
    String address
){

    // 정적 필드 예제
    public static final int LEGAL_ADULT_AGE = 18;

    // 인스턴스 메서드 예제
    public boolean isAdult() {
        return age >= LEGAL_ADULT_AGE;
    }

    // 정적 메서드 예제
    public static boolean isAdult(int age) {
        return age >= LEGAL_ADULT_AGE;
    }

    // 인스턴스에 대한 추가적인 정보를 제공하는 메서드
    public String greeting() {
        return "Hello, my name is " + name + " and I am " + (isAdult() ? "an adult." : "not an adult.");
    }

    public static Person defaultPerson(){
        return new Person("test", 123, "test");
    }
}
