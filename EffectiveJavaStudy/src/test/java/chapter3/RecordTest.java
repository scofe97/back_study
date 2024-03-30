package chapter3;

import org.example.chapter3.Person;
import org.junit.jupiter.api.Test;

public class RecordTest {

    @Test
    void recordTest(){
        Person person = Person.defaultPerson();
        Person person2 = new Person("test", 123, "test");
        Person person3 = new Person("test", 1234, "test");

        System.out.println("person2 = " + person);
        System.out.println(person.equals(person2));
        System.out.println(person.equals(person3));
    }
}
