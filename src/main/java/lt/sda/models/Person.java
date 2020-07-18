package lt.sda.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Objects;

public class Person implements Comparable<Person>{
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;

    public Person(String firstName, String lastName, LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String firstName, String lastName, String dateOfBirth){
        this(firstName, lastName, LocalDate.parse(dateOfBirth));
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        LocalDate now = LocalDate.now();
        return Period.between(dateOfBirth, now).getYears();
    }


    @Override
    public int hashCode(){
        return (firstName + lastName).hashCode();
    }

    @Override
    public boolean equals(Object o){
        return this.hashCode() == ((Person)o).hashCode();
    }

    @Override
    public int compareTo(Person other) {
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString(){
        return String.format("<Person firstName: %s lastName: %s age: %d>", getFirstName(), getLastName(), getAge());
    }
}
