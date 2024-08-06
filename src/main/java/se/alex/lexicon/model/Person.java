package se.alex.lexicon.model;

import java.time.LocalDate;

public class Person {
    private static int idCounter = 1;

    private final int id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final Gender gender;

    public Person(String firstName, String lastName, LocalDate birthDate, Gender gender) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                '}';
    }

}
