package chapter6;

import org.example.chapter6.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Chapter6Test {

    @Test
    void enumTest(){
        double mass = 5 / Planet.EARTH.surfaceGravity();
        for (Planet value : Planet.values()) {
            System.out.println(value.surfaceWeight(mass));
        }

        int x = 3;
        int y = 2;
        for (Operation value : Operation.values()) {
            System.out.printf("%d %s %d = %d %n",x, value, y, value.apply(x,y));
        }
    }

    @Test
    void enumSetTest(){
        NewText text = new NewText();
        text.applyStyles(EnumSet.of(NewText.Style.BOLD, NewText.Style.UNDERLINE));
    }

    @Test
    void enumMapTest(){
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        String baby = "baby";
        Integer i = 1;

        System.out.println(Objects.hash(baby));
        System.out.println(baby.hashCode());
    }

    @Test
    void enumMethodTest(){

        Week w = Week.FRIDAY;
        System.out.println(w.name()); // FRIDAY
        System.out.println(w.ordinal()); // 4

        Week w1 = Week.TUESDAY; // 2
        Week w2 = Week.SATURDAY; // 6
        System.out.println(w1.compareTo(w2)); // -4
        System.out.println(w2.compareTo(w1)); // 4

        Week w3 = Week.valueOf("SUNDAY");
        System.out.println(w3); // SUNDAY

        for (Week value : Week.values()) {
            System.out.println(value); // MONDAY ~ SUNDAY

        }
    }
}
