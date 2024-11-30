package org.example.chapter14.builder_fp;

public class TestMain14_builder_fp {
    public static void main(String[] args) {

        // LAZY BUILDER
        var builder = User.builder()
                .name(() -> "Ben Weidig")
                .email("ben@example.com");

        var user = builder.addPermission("create")
                .addPermission("edit")
                .build();

        System.out.println(user);


        // WITH BUILDER

        var user2 = UserWith.builder()
                .with(with -> {
                    with.email = "ben@example.com";
                    with.name = "Ben Weidig";
                })
                .withPermissions(permissions -> {
                    permissions.add("create");
                    permissions.add("view");
                })
                .build();

        System.out.println(user2);
    }
}
