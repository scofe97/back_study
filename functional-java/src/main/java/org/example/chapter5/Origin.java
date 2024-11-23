package org.example.chapter5;

public record Origin(int x, int y) {
    public Origin(){
        this(0, 0);
    }

    public static Origin ZERO = new Origin(0, 0);
}
