package org.example.chapter4.skeletal;

public abstract class AbstractBook implements Book {
    @Override
    public void openBook() {
        System.out.println("Opening the book.");
    }

    @Override
    public void closeBook() {
        System.out.println("Closing the book.");
    }

    // readBook 메소드는 템플릿 메소드로, 골격 구현에서 제공
    @Override
    public void readBook() {
        openBook();
        prepareContent();
        interpretContent();
        closeBook();
    }

    // prepareContent와 interpretContent는 여전히 추상 메소드로 남겨져 있어,
    // 서브 클래스에서 구현해야 함.
    @Override
    public abstract void prepareContent();

    @Override
    public abstract void interpretContent();
}
