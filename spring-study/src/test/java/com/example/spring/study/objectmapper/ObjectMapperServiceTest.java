package com.example.spring.study.objectmapper;

import com.example.spring.study.objectmapper.dto.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ObjectMapperService.class)
class ObjectMapperServiceTest {
    private ObjectMapperService objectMapperService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapperService = new ObjectMapperService(objectMapper);
    }

    @Test
    void personToJsonTest() throws Exception {
        // Arrange
        Person person = Person.builder().name("test").age(10).build();

        // Act
        String result = objectMapperService.personToJson();
        System.out.println("result1 = " + result);
    }

    @Test
    void jsonToPersonTest() throws Exception {
        // Arrange
        String personJson = "{\"name\":\"John Doe\",\"age\":30}";

        // Act
        Person result = objectMapperService.jsonToPerson(personJson);
        System.out.println("result2 = " + result);
    }

    @Test
    void jsonTest3() throws Exception {
        // Person 객체 생성
        Person person = new Person("John Doe", 30, "johndoe@example.com", "supersecret", LocalDate.of(1990, 1, 1));

        String jsonString = objectMapper.writeValueAsString(person);
        System.out.println("jsonString = " + jsonString);

        String jsonInput = "{\"name\":\"Jane Doe\",\"age\":25,\"email_address\":\"janedoe@example.com\",\"birthDate\":\"1995-05-30\"}";
        Person personFromJson = objectMapper.readValue(jsonInput, Person.class);
        System.out.println("personFromJson = " + personFromJson);
    }
}