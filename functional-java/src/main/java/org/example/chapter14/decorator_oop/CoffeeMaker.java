package org.example.chapter14.decorator_oop;

import java.util.List;

public interface CoffeeMaker {
    List<String> getIngredients();

    Coffee prepare();
}
