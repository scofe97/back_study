package collection.list;

public class BatchProcessorMain {

    public static void main(String[] args) {
        // MyArrayList<Integer> list = new MyArrayList<>();
        collection.list.MyLinkedList<Integer> list = new collection.list.MyLinkedList<>();

        collection.list.BatchProcessor process = new collection.list.BatchProcessor(list);
        process.logic(100_000);


    }
}
