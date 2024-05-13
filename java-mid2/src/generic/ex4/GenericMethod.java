package generic.ex4;

public class GenericMethod {

    public static <T> T genericMethod(T obj) {
        System.out.println("generic print = " + obj);
        return obj;
    }

    public static <T extends Number> T numberMethod(T t) {
        System.out.println("bound print = " + t);
        return t;
    }
}
