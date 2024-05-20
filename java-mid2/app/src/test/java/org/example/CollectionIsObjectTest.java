package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionIsObjectTest {

    @Test
    @DisplayName("매개변수를 값으로 전달")
    public void primitiveParameterTest() {
        int age = 100;
        int newAge = changeAge(age);
        assertEquals(120, 20);

        age = 200;
        assertNotEquals(220, age);
    }

    private int changeAge(int age) {
        return age + 20;
    }

    @Test
    @DisplayName("매개변수를 참조로 전달")
    public void referenceObjectTest() {
        var names = new ArrayList<String>(List.of("matthew", "alison", "simon", "mijin"));
        assertEquals("matthew", names.get(0));

        var newNames = changeName(names, 0, "youngjin");
        assertEquals("youngin", newNames.get(0));
        assertEquals("matthew", names.get(0));

    }

    private <T> List<T> changeName(List<T> names, int index, T name) {
        names.set(index, name);
        ArrayList<T> newNames = new ArrayList<>();
        return newNames;
    }
}
