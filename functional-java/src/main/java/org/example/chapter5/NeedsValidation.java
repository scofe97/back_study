package org.example.chapter5;

public record NeedsValidation(int x, int y) {
    public NeedsValidation {
        if (x < y) {
            throw new IllegalArgumentException("x must be less than y");
        }
    }
}
