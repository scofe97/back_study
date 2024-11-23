package org.example.chapter7;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record User(
        UUID id
        , String group
        , LocalDateTime lastLogin
        , List logEntries
) { }
