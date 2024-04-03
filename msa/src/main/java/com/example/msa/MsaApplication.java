package com.example.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class MsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaApplication.class, args);
	}


	// LocaleResolver 빈을 정의합니다. 이 빈은 애플리케이션에서 사용할 기본 로케일을 결정하는 역할을 합니다.
	@Bean
	public LocaleResolver localeResolver() {
		// SessionLocaleResolver 인스턴스를 생성합니다. 이 구현은 사용자의 로케일 정보를 세션에 저장합니다.
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();

		// 애플리케이션의 기본 로케일을 미국(US)으로 설정합니다.
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	// 메시지 소스 빈을 정의합니다. 이 빈은 애플리케이션의 국제화(i18n) 메시지를 관리하는 데 사용됩니다.
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

		// 메시지 코드를 찾을 수 없는 경우 코드 자체를 기본 메시지로 사용하도록 설정합니다.
		messageSource.setUseCodeAsDefaultMessage(true);

		// 메시지 소스 파일의 기본 이름을 설정합니다.
		messageSource.setBasenames("messages");
		return messageSource;
	}

}
