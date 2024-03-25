package org.example.chapter4.template;

// 비픽션 책을 위한 구체 클래스
public class NonFictionBook extends Book {
    @Override
    protected void prepareContent() {
        System.out.println("Preparing non-fiction book content.");
    }

    @Override
    protected void interpretContent() {
        System.out.println("Interpreting non-fiction book content.");
    }
}
