package org.example.chapter5;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class TestMain5_4 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var point = new Point(23, 42);

        try (var out = new ObjectOutputStream(new FileOutputStream("point.data"))) {
            out.writeObject(point);
        }

        var in = new ObjectInputStream(new FileInputStream("point.data"));
        var point2 = in.readObject();
        System.out.println("point2 = " + point2);
    }
}
