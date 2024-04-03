package org.example.chapter4.skeletal;

public interface Book {
    void openBook();
    void prepareContent();
    void interpretContent();
    void closeBook();
    void readBook(); // 템플릿 메소드
}
