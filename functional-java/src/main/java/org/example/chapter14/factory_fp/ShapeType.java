package org.example.chapter14.factory_fp;

import org.example.chapter14.factory_oop.*;

import java.util.Objects;
import java.util.function.Function;

public enum ShapeType {
    CIRCLE(Circle::new),
    TRIANGLE(Triangle::new),
    SQUARE(Square::new),
    PENTAGO(Pentagon::new);

    public final Function<Color, Shape> factory;

    ShapeType(Function<Color, Shape> factory) {
        this.factory = factory;
    }

    public Shape newInstance(Color color) {
        Objects.requireNonNull(color);
        return factory.apply(color);
    }
}
