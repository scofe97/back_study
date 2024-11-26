package org.example.chapter11;

import org.example.chapter5.User;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntSupplier;

public class TestMain11_2 {
    record User(String email, String name) {
    }

    static User loadUser(String email) {
        return new User("jane@doe.com", "Jane Doe");
    }

    public static void main(String... args) {

        Map<String, User> users = new HashMap<>();
        users.put("john@doe.com", new User("john@doe.com", "John Doe"));

        String email = "jane@doe.com";
        User user = users.computeIfAbsent(email, TestMain11_2::loadUser);

        System.out.println("user = " + user);
    }

}
