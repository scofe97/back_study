package headfirst.practice.facade;

public final class SimpleOrderFacade implements OrderFacade {
    private final InventorySystem inventory;
    private final PaymentSystem payment;
    private final ShippingSystem shipping;

    public SimpleOrderFacade(InventorySystem inventory, PaymentSystem payment, ShippingSystem shipping) {
        this.inventory = inventory;
        this.payment = payment;
        this.shipping = shipping;
    }

    @Override
    public void processOrder(String productId, String customerId, double amount, String address) {

        if (!inventory.checkStock(productId)) {
            System.out.println("Stock not available for product " + productId);
            return;
        }

        if (!payment.authorizePayment(customerId, amount)) {
            System.out.println("customerId = " + customerId);
            return;
        }

        inventory.reduceStock(productId);
        payment.capturePayment(customerId, amount);
        String label = shipping.generateShippingLabel(productId, address);

        System.out.println("label = " + label);
    }
}
