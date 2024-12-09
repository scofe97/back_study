package org.example.book.chapter1.quack;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("꽼!");
    }
}
