package org.example.chapter14.decorator_fp;

import org.example.chapter14.decorator_oop.*;

import java.util.Arrays;
import java.util.function.Function;

public final class Barista {

    public static CoffeeMaker decorate(CoffeeMaker coffeeMaker
    , Function<CoffeeMaker, CoffeeMaker> decorator) {
        return decorator.apply(coffeeMaker);
    }

    public static CoffeeMaker decorate2(CoffeeMaker coffeeMaker
    , Function<CoffeeMaker, CoffeeMaker>... decorator) {
        Function<CoffeeMaker, CoffeeMaker> reducedDecorations = Arrays.stream(decorator)
                .reduce(Function.identity()
                        , Function::andThen);

        return reducedDecorations.apply(coffeeMaker);
    }

    private Barista() {}
}
