package org.example.book.chapter1;

import org.example.book.chapter1.fly.FlyBehavior;
import org.example.book.chapter1.quack.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("오리는 물에 뜬다.");
    }
}
