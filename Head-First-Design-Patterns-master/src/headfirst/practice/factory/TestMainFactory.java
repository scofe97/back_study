package headfirst.practice.factory;

public class TestMainFactory {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());

        pizzaStore.orderPizza("cheese");
        pizzaStore.orderPizza("clam");
    }
}
