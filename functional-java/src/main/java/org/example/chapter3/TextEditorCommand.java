package org.example.chapter3;

import java.util.function.Supplier;

public interface TextEditorCommand extends Supplier<String> {
    String execute();

    default String get() {
        return execute();
    }
}
