package org.example.chapter14.strategy_oop;

public class StandardShipping implements ShippingStrategy {
    @Override
    public void ship(Parcel parcel) {
        System.out.println("Standard Shipping");
    }
}
