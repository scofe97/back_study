package org.example.chapter1_solid.ch2;


import lombok.Getter;
import lombok.Setter;

// 기본 클래스 - 수정에 닫혀있다.
@Getter
@Setter
public abstract class Subscriber {
    protected Long subscriberId;

    protected String address;

    protected Long phoneNumber;

    protected int baseRate;

    public abstract double calculateBill(); // 확장 가능
}
