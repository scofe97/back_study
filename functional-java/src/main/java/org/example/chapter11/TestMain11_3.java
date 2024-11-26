package org.example.chapter11;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class TestMain11_3 {

    record Role(String name) { }
    record User(List<Role> roles) { }

    static class DAO {
        public List<Role> loadAllAvailableRoles() {
            return List.of(new Role("admin"), new Role("guest"));
        }

        public List<Role> loadAllAvailableRoles2() {
            return List.of(new Role("admin"), new Role("guest"));
        }
    }

    static User updateUser(User user, List<Role> availableRoles) {
        return new User(availableRoles);
    }

    static User updateUserLamda(User user, Supplier<List<Role>> availableRolesFn) {

        var availableRoles = availableRolesFn.get();
        return new User(availableRoles);
    }

    public static void main(String... args) {

        var dao = new DAO();

        User user = new User(Collections.emptyList());
        System.out.println("user = " + user);

        List<Role> availableRoles = dao.loadAllAvailableRoles();
        User updateUser = updateUser(user, availableRoles);
        System.out.println("updateUser = " + updateUser);

        User updateUserLamda = updateUserLamda(user, dao::loadAllAvailableRoles);
        System.out.println("updateUserLamda = " + updateUserLamda);
    }
}
