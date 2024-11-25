package org.example.chapter9;

public class TestMain9_1 {

    public static void main(String[] args) {
        var user = new User(42L, "Ben", null);

        var fullName = user.fullName();

        // NullPointerException 발생
        // var initials = user.initials();
    }
}
