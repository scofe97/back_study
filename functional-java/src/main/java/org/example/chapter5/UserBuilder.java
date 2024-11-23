package org.example.chapter5;

import java.time.LocalDateTime;

public final class UserBuilder {

    private final String userName;
    private boolean active;
    private LocalDateTime lastLogin;

    public UserBuilder(String userName) {
        this.userName = userName;
        this.active = true;
    }

    public UserBuilder active(boolean isActive) {
        if (this.active == false) {
            throw new IllegalArgumentException();
        }

        this.active = isActive;
        return this;
    }

    public UserBuilder lastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public User build() {
        return new User(userName, active, lastLogin);
    }
}
