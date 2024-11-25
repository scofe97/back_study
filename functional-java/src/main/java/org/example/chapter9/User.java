package org.example.chapter9;

public record User(
        long id,
        String firstName,
        String lastName
) {

    String fullName(){
        return String.format("%s %s", firstName(), lastName());
    }

    String initials(){
        return String.format("%s %s", lastName().substring(0,1), firstName().substring(0,1));
    }
}
