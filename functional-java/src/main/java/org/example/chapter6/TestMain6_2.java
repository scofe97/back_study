package org.example.chapter6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class TestMain6_2 {
    public static void main(String[] args) {
        Stream<Shape> flatMap = Stream.of(Shape.square(), Shape.triangle(), Shape.circle())
                .map(Shape::twice)
                .flatMap(List::stream);


        Stream<Shape> mapMulti = Stream.of(Shape.square(), Shape.triangle(), Shape.circle())
                .mapMulti((shape, downstream) ->
                        shape.twice().forEach(downstream::accept));
    }
}
