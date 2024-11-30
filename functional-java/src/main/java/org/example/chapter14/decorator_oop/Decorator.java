package org.example.chapter14.decorator_oop;

import java.util.List;
import java.util.function.Function;

public abstract class Decorator implements CoffeeMaker{

    private final CoffeeMaker target;

    public Decorator(CoffeeMaker target) {
        this.target = target;
    }

    @Override
    public List<String> getIngredients() {
        return this.target.getIngredients();
    }

    @Override
    public Coffee prepare() {
        return this.target.prepare();
    }

    public static Function<CoffeeMaker, CoffeeMaker> addMilk(MilkCarton milkCarton) {
        return coffeeMaker -> new AddMilkDecorator(coffeeMaker, milkCarton);
    }

    public static Function<CoffeeMaker, CoffeeMaker> addSugar() {
        return AddSugarDecorator::new;
    }
}
