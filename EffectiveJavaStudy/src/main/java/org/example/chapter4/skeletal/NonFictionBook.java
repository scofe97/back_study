package org.example.chapter4.skeletal;

import org.example.chapter4.template.Book;

// 비픽션 책을 위한 구체 클래스
public class NonFictionBook extends AbstractBook {
    @Override
    public void prepareContent() {
        System.out.println("Preparing non-fiction book content.");
    }

    @Override
    public void interpretContent() {
        System.out.println("Interpreting non-fiction book content.");
    }
}
