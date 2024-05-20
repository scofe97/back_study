package org.example.collection.list;

public class BatchProcessorMain {

    public static void main(String[] args) {
        // MyArrayList<Integer> list = new MyArrayList<>();
        MyLinkedList<Integer> list = new MyLinkedList<>();

        BatchProcessor process = new BatchProcessor(list);
        process.logic(100_000);


    }
}
