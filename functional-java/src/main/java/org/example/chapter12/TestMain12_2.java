package org.example.chapter12;

import java.util.Stack;

public class TestMain12_2 {
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


        traversIterative(root);
    }

    public static void traversIterative(Node<String> root) {
        Stack<Node<String>> tmpNodes = new Stack<>();
        var current = root;

        while(!tmpNodes.isEmpty() || current != null) {
            if(current != null) {
                tmpNodes.push(current);
                current = current.left();
                continue;
            }

            current = tmpNodes.pop();
            System.out.println("current.value() = " + current.value());

            current = current.right();
        }
    }

    public static void traversRecursive(Node<String> node) {
        if (node == null) {
            return;
        }

        traversRecursive(node.left());

        System.out.println("node.value() = " + node.value());

        traversRecursive(node.right());
    }
}
