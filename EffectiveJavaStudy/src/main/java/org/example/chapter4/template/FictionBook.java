package org.example.chapter4.template;

// 픽션 책을 위한 구체 클래스
public class FictionBook extends Book {
    @Override
    protected void prepareContent() {
        System.out.println("Preparing fiction book content.");
    }

    @Override
    protected void interpretContent() {
        System.out.println("Interpreting fiction book content.");
    }
}
