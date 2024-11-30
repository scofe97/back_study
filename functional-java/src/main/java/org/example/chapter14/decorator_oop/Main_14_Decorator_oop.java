package org.example.chapter14.decorator_oop;

public class Main_14_Decorator_oop {
    public static void main(String[] args) {
        BlackCoffeeMaker coffeeMaker = new BlackCoffeeMaker();

        CoffeeMaker firstDecorated = new AddMilkDecorator(coffeeMaker, new MilkCarton());
        CoffeeMaker secondDecorated = new AddSugarDecorator(firstDecorated);

        System.out.println("secondDecorated.getIngredients() = " + secondDecorated.getIngredients());
        System.out.println("secondDecorated.prepare() = " + secondDecorated.prepare());
    }
}
