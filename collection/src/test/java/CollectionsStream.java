import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

public class CollectionsStream {

    @Test
    @DisplayName("intermediate와 terminal operation")
    public void operationType() {
        List<Widget> widgets = List.of(
                new Widget("who are you", "input", Color.RED, 12),
                new Widget("main grid", "table", Color.GREEN, 32),
                new Widget("some link", "link", Color.RED, 7)
        );

        int sum = widgets.stream()
                .filter(w -> w.color() == Color.RED)
                .mapToInt(w -> w.weight)
                .sum();

        System.out.println("sum = " + sum);
    }

    record Widget(
            String title,
            String type,
            Color color,
            int weight
    ){}

    enum Color {
        RED,
        WHITE,
        BLACK,
        GREEN
    }
}
