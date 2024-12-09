package headfirst.practice.factory.chapter2;

public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new NYStyleCheesePizza();
            case "veggie" -> new NYStyleVeggiePizza();
            case "clam" -> new NYStyleClamPizza();
            case "pepperoni" -> new NYStylePepperoniPizza();
            default -> null;
        };
    }

}
