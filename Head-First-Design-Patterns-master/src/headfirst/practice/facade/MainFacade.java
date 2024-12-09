package headfirst.practice.facade;

public class MainFacade {
    public static void main(String[] args) {
        InventorySystem inv = new InventorySystem();
        PaymentSystem pay = new PaymentSystem();
        ShippingSystem ship = new ShippingSystem();

        OrderFacade facade = new SimpleOrderFacade(inv, pay, ship);

        facade.processOrder("PRODUCT-001", "CUSTOMER-ABC", 99.99, "123 Street, City");
    }
}
