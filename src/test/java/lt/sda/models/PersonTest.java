package lt.sda.models;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void testGetAge(){
        Person person = new Person("Testas", "Testinis", LocalDate.parse("2000-01-01"));

        assertEquals(20, person.getAge());
    }
}
