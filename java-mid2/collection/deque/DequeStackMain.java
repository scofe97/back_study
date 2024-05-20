package org.example.collection.deque;

import java.util.ArrayDeque;

public class DequeStackMain {
    public static void main(String[] args) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque);

        System.out.println("deque = " + deque.peek());

        System.out.println("deque.pop() = " + deque.pop());
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println(deque);
    }
}
