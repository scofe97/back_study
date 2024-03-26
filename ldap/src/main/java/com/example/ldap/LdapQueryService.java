package com.example.ldap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ldap.NamingException;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

import javax.naming.directory.Attributes;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LdapQueryService {

    private final LdapTemplate ldapTemplate;

    public List<String> findAll()  {

        LdapQuery query = LdapQueryBuilder.query()
                .where("objectclass").is("person");

        List<String> search = ldapTemplate.search(query, new AttributesMapper<String>() {
            public String mapFromAttributes(Attributes attrs) throws NamingException {
                return attrs.get("cn").toString(); // "cn"은 일반적인 사용자의 이름을 나타냅니다.
            }
        });

        for (String s : search) {
            log.info(s);
        }

        return search;
    }

}
