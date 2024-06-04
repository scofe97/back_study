package com.example.spring.study.objectmapper;

import com.example.spring.study.objectmapper.dto.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@RequiredArgsConstructor
public class ObjectMapperService {

    private final ObjectMapper objectMapper;

    public String personToJson() throws Exception {
        Person person = Person.builder().name("test").age(10).build();
        return objectMapper.writeValueAsString(person);
    }
    public Person jsonToPerson(@RequestBody String personJson) throws Exception {
        return objectMapper.readValue(personJson, Person.class);
    }
}
