package org.example.collection.link;

public class NodeMain2 {
    public static void main(String[] args) {

        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");

        System.out.println("연결된 노드 출력");
        System.out.println(first);


    }
}
