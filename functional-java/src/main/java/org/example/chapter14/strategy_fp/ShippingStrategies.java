package org.example.chapter14.strategy_fp;

import org.example.chapter14.strategy_oop.ExpeditedShipping;
import org.example.chapter14.strategy_oop.ShippingStrategy;
import org.example.chapter14.strategy_oop.StandardShipping;

public class ShippingStrategies {

    public static ShippingStrategy expedited(boolean requiresSignature) {
        return parcel -> new ExpeditedShipping(requiresSignature);
    }

    public static ShippingStrategy standardShipping() {
        return new StandardShipping();
    }
}
