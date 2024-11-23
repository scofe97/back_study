package org.example.chapter5;

import java.time.LocalDateTime;
import java.util.Objects;

public final class User {

    // 1. 변수 final 선언
    private final String userName;
    private final boolean active;
    private final LocalDateTime lastLogin;

    // 2. final은 무조건적으로 초기화되어야해서 모든 필수값이 존재해야 한다.
    public User(String userName, boolean active, LocalDateTime lastLogin) {
        this.userName = userName;
        this.active = active;
        this.lastLogin = lastLogin;
    }

    // 3. setter 제거
    public String getUserName() {
        return userName;
    }

    public boolean isActive() {
        return active;
    }
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return active == user.active && Objects.equals(userName, user.userName) && Objects.equals(lastLogin, user.lastLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, active, lastLogin);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", active=" + active +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
