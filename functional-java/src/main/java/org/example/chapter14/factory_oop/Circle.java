package org.example.chapter14.factory_oop;//
// A FUNCTIONAL APPROACH TO JAVA
// Chapter 14 - Design Patterns
//

public class Circle extends Shape {

    public Circle(Color color) {
        super(0, color, ShapeType.CIRCLE);
    }
}
