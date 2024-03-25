package org.example.chapter4.template;

public abstract class Book {
    // 템플릿 메소드
    public final void readBook() {
        openBook();
        prepareContent();
        interpretContent();
        closeBook();
    }

    // 모든 책에 공통적인 방법으로 책을 여는 단계
    private void openBook() {
        System.out.println("Opening the book.");
    }

    // 모든 책에 공통적인 방법으로 책을 닫는 단계
    private void closeBook() {
        System.out.println("Closing the book.");
    }



    // 책의 내용을 준비하는 단계 - 서브클래스에서 구현
    protected abstract void prepareContent();

    // 책의 내용을 해석하는 단계 - 서브클래스에서 구현
    protected abstract void interpretContent();
}
