package com.example.ldap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfig {

    @Value("${spring.ldap.urls}")
    private String ldapUrl;

    @Value("${spring.ldap.base}")
    private String ldapBase;

    @Value("${spring.ldap.username}")
    private String ldapUserDn;

    @Value("${spring.ldap.password}")
    private String ldapPassword;

    @Value("${spring.ldap.keystore}")
    private String keystorePath;

    @Value("${spring.ldap.keystorePassword}")
    private String keystorePassword;

    @Value("${spring.ldap.keystoreType}")
    private String keystoreType;

    @Value("${spring.ldap.truststore}")
    private String truststorePath;

    @Value("${spring.ldap.truststorePassword}")
    private String truststorePassword;

    @Bean
    public LdapContextSource contextSource() {
        //setSslProperty();

        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl(ldapUrl);
        contextSource.setBase(ldapBase);
        contextSource.setUserDn(ldapUserDn);
        contextSource.setPassword(ldapPassword);

        return contextSource;
    }

    private void setSslProperty() {
        System.setProperty("javax.net.ssl.keyStore", keystorePath);
        System.setProperty("javax.net.ssl.keyStorePassword", keystorePassword);
        System.setProperty("javax.net.ssl.keyStoreType", keystoreType);
        System.setProperty("javax.net.ssl.trustStore", truststorePath);
        System.setProperty("javax.net.ssl.trustStorePassword", truststorePassword);
    }

    @Bean
    public LdapTemplate ldapTemplate(LdapContextSource contextSource) {
        return new LdapTemplate(contextSource);
    }
}
