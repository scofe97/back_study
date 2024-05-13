package generic.ex5;

import generic.animal.Animal;
import generic.animal.Dog;

public class WildcardEx {

    static <T> void printGenericV1(Box<T> box) {
        System.out.println("T = " + box.getValue());
    }

    static void printWildcardV1(Box<?> box) {
        System.out.println("? = " + box.getValue());
    }


    static <T extends Animal> void printGenericV2(Box<T> box) {
        T t = box.getValue();
        System.out.println("t.getName() = " + t.getName());
    }

    static void printWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.getValue();
        System.out.println("animal.getName() = " + animal.getName());
    }

    static <T extends Animal> T printAndReturnGeneric(Box<T> box) {
        T t = box.getValue();
        System.out.println("이름 = " + t.getName());
        return t;
    }

    static Animal printAndReturnWildcard(Box<? extends Animal> box) {
        Animal animal = box.getValue();
        System.out.println("이름 = " + animal.getName());
        return animal;
    }

    static void writeBox(Box<? super Animal> box) {
        box.setValue(new Dog("멍멍이", 100));
    }
}
