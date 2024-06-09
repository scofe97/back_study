package com.example.study.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Getter
@ConfigurationProperties(prefix= "accounts")
@Validated
@RequiredArgsConstructor
public class AccountsProperties {

    @NotEmpty(message = "메시지를 입력해야 합니다")
    private final String message;

    @Valid
    private final ContactDetails contactDetails;

    @NotEmpty(message = "긴급 연락처 목록을 입력해야 합니다")
    private final List<@NotEmpty @Size(min = 10, max = 20, message = "전화번호는 10자에서 20자 사이여야 합니다") String> onCallSupport;

    @RequiredArgsConstructor
    @Getter
    public static class ContactDetails {
        @NotEmpty(message = "이름을 입력해야 합니다")
        private final String name;

        @Email(message = "유효한 이메일을 입력해야 합니다")
        @NotEmpty(message = "이메일을 입력해야 합니다")
        private final String email;
    }
}