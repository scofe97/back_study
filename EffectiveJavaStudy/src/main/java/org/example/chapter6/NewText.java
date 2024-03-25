package org.example.chapter6;

import java.util.Set;

public class NewText {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    public void applyStyles(Set<Style> styles) {
        System.out.println(styles);
    }
}