package org.example.chapter14.strategy_oop;

public interface ShippingService {
   default void ship(Parcel parcel, ShippingStrategy strategy){
       strategy.ship(parcel);
   }
}
