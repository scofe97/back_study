package org.example.chapter5;

import java.util.Collections;
import java.util.List;

public record IncreaseImmutability(List<String> values) {

    public IncreaseImmutability {
        values = Collections.unmodifiableList(values);

        // 또는 List.of를 통한 깊은 복사
        values = List.copyOf(values);
    }
}
