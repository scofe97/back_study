package org.example.chapter5;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public record UserRecordEx(
        String userName,
        boolean active,
        Optional<String> group,
        LocalDateTime lastLogin
) {

    public UserRecordEx {
        Objects.requireNonNull(userName);
        Objects.requireNonNull(lastLogin);
        userName = userName.toLowerCase();

        Objects.requireNonNull(group, "Optional<String> group must not be null");
    }
}
