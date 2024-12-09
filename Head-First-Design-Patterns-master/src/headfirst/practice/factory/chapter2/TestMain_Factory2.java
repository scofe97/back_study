package headfirst.practice.factory.chapter2;

public class TestMain_Factory2 {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza cheese = nyStore.orderPizza("cheese");
        Pizza clam = nyStore.orderPizza("clam");

        Pizza cheese1 = chicagoStore.orderPizza("cheese");
        Pizza clam1 = chicagoStore.orderPizza("clam");
    }
}
