package org.example.chapter6;

public enum Esemble {
    SOLO, DUET, TRIO, QUARTET, QUINTET, SEXTET, SEPTET, OCTET, NONET, DECTET;

    // ordinal을 잘못 사용한 경우
    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}