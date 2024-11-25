package org.example.chapter9;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class TestMain9_5 {

    record Permissions(
            List<String> permissions,
            Group group
    ){
        public boolean isEmpty() {
            return this.permissions.isEmpty();
        }
    }
    record Group(Optional<User> admin) { }

    record User(boolean isActive) { }


    public static void main(String[] args) {

        User admin = new User(true);
        Group group = new Group(Optional.of(admin));

        Permissions permissions = new Permissions(List.of("A", "B", "C"), group);

        Boolean isActiveAdmin = Optional.of(permissions)
                // permissions 비어 있지 않은 경우만 처리
                .filter(Predicate.not(Permissions::isEmpty))
                // Permissions Group 객체를 추출
                .map(Permissions::group)
                // Group admin(User 객체)을 Optional 추출
                .flatMap(Group::admin)
                .map(User::isActive)
                .orElse(Boolean.FALSE);

        System.out.println("isActiveAdmin = " + isActiveAdmin);
    }
}
