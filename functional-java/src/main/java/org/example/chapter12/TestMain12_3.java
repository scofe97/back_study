package org.example.chapter12;

import java.util.Stack;

public class TestMain12_3 {
    public static void main(String[] args) {

        var root = Node.of("1",
                Node.of("2",
                        Node.of("4",
                                Node.of("7"),
                                Node.of("8")),
                        Node.of("5")),
                Node.right("3",
                        Node.left("6",
                                Node.of("9"))));

        System.out.println("tree = " + root);
        root.traverse(System.out::println);
    }
}
