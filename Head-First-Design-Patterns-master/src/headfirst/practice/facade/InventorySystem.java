package headfirst.practice.facade;

public class InventorySystem {
    boolean checkStock(String productId) {
        System.out.println("check productId = " + productId);
        return true;
    }

    void reduceStock(String productId) {
        System.out.println("reducing productId = " + productId);
    }
}
