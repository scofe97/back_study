package headfirst.practice.facade;

public class ShippingSystem {
    String generateShippingLabel(String productId, String address) {
        System.out.println("generate productId = " + productId + ", address = " + address);
        return "LABEL-12345";
    }
}
