package org.example.chapter14.factory_oop;//
// A FUNCTIONAL APPROACH TO JAVA
// Chapter 14 - Design Patterns
//

public class Triangle extends Shape {

    public Triangle(Color color) {
        super(3, color, ShapeType.TRIANGLE);
    }
}