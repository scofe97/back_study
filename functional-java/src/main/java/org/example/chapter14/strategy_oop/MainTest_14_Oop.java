package org.example.chapter14.strategy_oop;

public class MainTest_14_Oop {
    public static void main(String[] args) {

        ShippingService shippingService = new ShippingService() {};
        Parcel parcel = new Parcel();

        shippingService.ship(parcel, new StandardShipping());
        shippingService.ship(parcel, new ExpeditedShipping(true));
    }
}
