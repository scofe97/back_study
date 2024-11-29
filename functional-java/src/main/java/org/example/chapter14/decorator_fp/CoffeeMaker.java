package org.example.chapter14.decorator_fp;

import java.util.List;

public interface CoffeeMaker {
    List<String> getIngredients();

    Coffee prepare();
}
