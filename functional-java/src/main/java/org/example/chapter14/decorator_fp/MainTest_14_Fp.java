package org.example.chapter14.decorator_fp;

import org.example.chapter14.decorator_oop.*;

public class MainTest_14_Fp {
    public static void main(String[] args) {
        CoffeeMaker decoratedCoffeeMaker = Barista.decorate(new BlackCoffeeMaker(), coffeeMaker -> new AddMilkDecorator(coffeeMaker, new MilkCarton()));
        CoffeeMaker finalCoffeeMaker = Barista.decorate(decoratedCoffeeMaker, AddSugarDecorator::new);

        CoffeeMaker coffeeMaker1 = Barista.decorate2(
                new BlackCoffeeMaker()
                , coffeeMaker ->
                        new AddMilkDecorator(coffeeMaker, new MilkCarton())
                , AddSugarDecorator::new
        );

        CoffeeMaker coffeeMaker2 = Barista.decorate2(
                new BlackCoffeeMaker(),
                Decorator.addMilk(new MilkCarton()),
                Decorator.addSugar()
        );
        Coffee lastCoffee = coffeeMaker2.prepare();
        System.out.println("lastCoffee = " + lastCoffee);

    }
}
