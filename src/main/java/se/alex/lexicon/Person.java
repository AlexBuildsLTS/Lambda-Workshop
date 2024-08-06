package se.alex.lexicon;

import java.time.LocalDate;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;

    public Person(int id, String firstName, String lastName, LocalDate birthDate, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getGender() { return gender; }

    @Override
    public String toString() {
        return firstName + " " + lastName + " born " + birthDate.toString();
    }
}
