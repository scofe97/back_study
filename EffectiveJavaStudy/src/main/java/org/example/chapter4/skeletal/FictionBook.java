package org.example.chapter4.skeletal;

import org.example.chapter4.template.Book;

// 픽션 책을 위한 구체 클래스
public class FictionBook extends AbstractBook {
    @Override
    public void prepareContent() {
        System.out.println("Preparing fiction book content.");
    }

    @Override
    public void interpretContent() {
        System.out.println("Interpreting fiction book content.");
    }
}
