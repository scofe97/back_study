package org.example.chapter6;

public enum Operation {
    PLUS("+") {public int apply(int x, int y) {return x+y;}},
    MINUS("-") {public int apply(int x, int y) {return x-y;}},
    TIME("*") {public int apply(int x, int y) {return x*y;}},
    DIVIDE("/") {public int apply(int x, int y) {return x/y;}};

    private final String symbol;
    Operation(String symbol) {
        this.symbol = symbol;}
    public abstract int apply(int x, int y);


    @Override
    public String toString() {
        return symbol;
    }
}