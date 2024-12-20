package org.example.chapter14.builder_fp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public record UserWith(String email, String name, List<String> permissions) {

    public UserWith {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("'email' must be set.");
        }

        if (permissions == null) {
            permissions = Collections.emptyList();
        }
    }

    public static class Builder {

        public String email;
        public String name;
        private final List<String> permissions = new ArrayList<>();

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder addPermission(String permission) {
            this.permissions.add(permission);
            return this;
        }

        public Builder with(Consumer<Builder> builderFn) {
            builderFn.accept(this);
            return this;
        }

        public Builder withPermissions(Consumer<List<String>> permissionsFn) {
            permissionsFn.accept(this.permissions);
            return this;
        }

        public UserWith build() {
            return new UserWith(this.email,
                    this.name,
                    this.permissions);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
