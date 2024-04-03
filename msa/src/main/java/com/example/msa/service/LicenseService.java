package com.example.msa.service;

import com.example.msa.model.License;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LicenseService {

    // MessageSource 인터페이스의 인스턴스
    // 국제화(i18n) 관리
    private final MessageSource messages;

    public License getLicense(String licenseId, String organizationId){
        return License.builder()
                .id(new Random().nextInt(1000))
                .licenseId(licenseId)
                .organizationId(organizationId)
                .description("Software product")
                .productName("Ostock")
                .licenseType("full")
                .build();
    }

    public String createLicense(License license, String organizationId, Locale locale){
        if(Objects.isNull(license) && Objects.isNull(organizationId)) return null;

        License changeLicence = license.withOrganizationId(organizationId);
        return String.format(messages.getMessage("license.create.message",null,locale), changeLicence.toString()); // 특정 메시지를 조회하기 위해 전달된 로케일 설정
    }

    public String updateLicense(License license, String organizationId){
        if(Objects.isNull(license) && Objects.isNull(organizationId)) return null;

        License changeLicence = license.withOrganizationId(organizationId);
        return String.format(messages.getMessage("license.update.message", null, null), changeLicence.toString()); // 특정 메시지를 조회하기 위해 null 로케일 설정
    }

    public String deleteLicense(String licenseId, String organizationId){
        String responseMessage = null;
        responseMessage = String.format(messages.getMessage("license.delete.message", null, null),licenseId, organizationId);
        return responseMessage;

    }

}
