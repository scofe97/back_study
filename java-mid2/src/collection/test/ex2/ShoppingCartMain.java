package collection.test.ex2;

public class ShoppingCartMain {
    public static void main(String[] args) {
        collection.test.ex2.ShoppingCart cart = new collection.test.ex2.ShoppingCart();

        collection.test.ex2.Item item1 = new collection.test.ex2.Item("마늘", 2000, 2);
        collection.test.ex2.Item item2 = new collection.test.ex2.Item("상추", 3000, 4);

        cart.add(item1);
        cart.add(item2);

        cart.displayItem();
    }
}
