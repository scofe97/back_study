package org.example.chapter14.strategy_oop;

public class ExpeditedShipping implements ShippingStrategy {

    private final boolean signatureRequired;

    public ExpeditedShipping(boolean signatureRequired) {
        this.signatureRequired = signatureRequired;
    }

    @Override
    public void ship(Parcel parcel) {
        System.out.println(String.format("Shipping Parcel with '%s' (signature=%s)", getClass().getSimpleName(), this.signatureRequired));
    }
}
