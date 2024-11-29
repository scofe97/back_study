package org.example.chapter14.factory_oop;//
// A FUNCTIONAL APPROACH TO JAVA
// Chapter 14 - Design Patterns
//

import org.example.chapter14.factory_oop.ShapeType;

public class Pentagon extends Shape {

    public Pentagon(Color color) {
        super(5, color, ShapeType.PENTAGON);
    }
}