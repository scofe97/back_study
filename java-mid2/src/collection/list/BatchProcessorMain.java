package collection.list;

public class BatchProcessorMain {

    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        BatchProcessor process1 = new BatchProcessor(list1);
        process1.logic(100_000);

        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        BatchProcessor process2 = new BatchProcessor(list2);
        process2.logic(100_000);
    }
}
