package chapter7;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.function.*;

public class FunctionalTest {

    @Test
    void functionTest(){
        Consumer<String> printer = System.out::println;
        printer.accept("Hello, Consumer!");


        Supplier<LocalDate> todaySupplier = LocalDate::now;
        System.out.println("Today is: " + todaySupplier.get());


        Function<String, Integer> lengthFunction = String::length;
        System.out.println("String length is: " + lengthFunction.apply("Hello, Function!"));


        Predicate<String> isNonEmpty = s -> !s.isEmpty();
        System.out.println("Is non-empty: " + isNonEmpty.test("Hello, Predicate!"));
        System.out.println("Is non-empty: " + isNonEmpty.test(""));


        IntSupplier test = () -> 5;
        int asInt = test.getAsInt();
        System.out.println("asInt = " + asInt);
    }
}
