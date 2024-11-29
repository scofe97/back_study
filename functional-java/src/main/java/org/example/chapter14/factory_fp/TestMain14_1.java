package org.example.chapter14.factory_fp;

import org.example.chapter14.factory_oop.Color;
import org.example.chapter14.factory_oop.Shape;
import org.example.chapter14.factory_fp.ShapeType;

import java.util.function.Function;

public class TestMain14_1 {
    public static void main(String[] args) {
        Shape shapeTest = ShapeType.CIRCLE.newInstance(Color.RED);

        Function<Shape, Shape> cornerPint = shape -> {
            System.out.println("Shape Created With " + shape.corners() + " corners");
            return shape;
        };

        ShapeType.CIRCLE.factory.andThen(cornerPint)
                .apply(Color.RED);
        ShapeType.SQUARE.factory.andThen(cornerPint)
                .apply(Color.RED);
    }
}
