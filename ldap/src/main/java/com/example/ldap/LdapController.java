package com.example.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ldap")
public class LdapController {

    private final LdapQueryService ldapQueryService;

    @Autowired
    public LdapController(LdapQueryService ldapQueryService) {
        this.ldapQueryService = ldapQueryService;
    }

    @GetMapping("/findAll")
    public List<String> findAll() throws Exception {
        return ldapQueryService.findAll();
    }
}
