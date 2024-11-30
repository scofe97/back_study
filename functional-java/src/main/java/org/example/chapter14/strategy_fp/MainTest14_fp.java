package org.example.chapter14.strategy_fp;

import org.example.chapter14.strategy_oop.Parcel;
import org.example.chapter14.strategy_oop.ShippingService;
import org.example.chapter14.strategy_oop.ShippingStrategy;

public class MainTest14_fp {
    public static void main(String[] args) {

        Parcel parcel = new Parcel();
        ShippingService shippingService = new ShippingService() {};

        shippingService.ship(parcel, ShippingStrategies.standardShipping());
        shippingService.ship(parcel, ShippingStrategies.expedited(true));
    }
}
