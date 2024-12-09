package headfirst.practice.facade;

public sealed interface OrderFacade permits SimpleOrderFacade {
    void processOrder(String productId, String customerId, double amount, String address);
}
