package org.example.chapter9;

import javax.lang.model.type.NullType;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class TestMain9_6 {

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

        List<Permissions> permissions = List.of(new Permissions(List.of("A", "B", "C"),
                group));

        List<User> activeUsers = permissions.stream()
                .filter(Predicate.not(Permissions::isEmpty))
                .map(Permissions::group)
                .map(Group::admin)
                .filter(Optional::isPresent) // 값 존재확인
                .map(Optional::orElseThrow) // 값 꺼내기
                .filter(User::isActive)
                .toList();

        List<User> activeUsers2 = permissions.stream()
                .filter(Predicate.not(Permissions::isEmpty))
                .map(Permissions::group)
                .map(Group::admin)
                .flatMap(Optional::stream) // 내부값이 존재하면 Stream<T> 반환
                .filter(User::isActive)
                .toList();
    }
}
