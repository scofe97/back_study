package headfirst.practice.facade;

public class PaymentSystem {
    boolean authorizePayment(String customerId, double amount) {
        System.out.println("capturing amount = " + amount);
        System.out.println("authorize customerId = " + customerId);
        return true;
    }

    void capturePayment(String customerId, double amount) {
        System.out.println("capturing amount = " + amount);
        System.out.println("capturing customerId = " + customerId);
    }
}
