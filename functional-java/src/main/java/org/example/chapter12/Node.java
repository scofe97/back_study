package org.example.chapter12;

import java.util.function.Consumer;

public record Node<T>(
        T value,
        Node<T> left,
        Node<T> right
) {

    public static <T> Node<T> of(T value, Node<T> left, Node<T> right) {
        return new Node<>(value, left, right);
    }

    public static <T> Node<T> of(T value) {
        return org.example.chapter12.Node.of(value, null, null);
    }

    public static <T> Node<T> left(T value, Node<T> left) {
        return Node.of(value, left, null);
    }

    public static <T> Node<T> right(T value, Node<T> right) {
        return org.example.chapter12.Node.of(value, null, right);
    }

    public static <T> void traverse(Node<T> root, Consumer<T> fn) {
        if(root == null) return;

        traverse(root.left, fn);

        fn.accept(root.value);

        traverse(root.right, fn);
    }

    public void traverse(Consumer<T> fn) {
        Node.traverse(this, fn);
    }
}
