package org.example.chapter14;

import java.awt.*;

public record Circle(Color color) implements Shape {

    public int corners(){
        return 0;
    }

    public ShapeType type() {
        return ShapeType.CIRCLE;
    }
}
