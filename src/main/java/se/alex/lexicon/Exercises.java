package se.alex.lexicon;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class Exercises {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person(123, "Erik", "Eriksson", LocalDate.parse("2000-01-01"), "Male"),
                new Person(124, "Anna", "Andersson", LocalDate.parse("1990-05-12"), "Female"),
                new Person(125, "Nisse", "Nilsson", LocalDate.parse("1999-09-09"), "Male"),
                new Person(126, "Ulf", "Ulsson", LocalDate.parse("1980-07-22"), "Male"),
                new Person(456, "Nisse", "Nilsson", LocalDate.parse("1999-09-09"), "Male")

        );

        DataStorageImpl storage = new DataStorageImpl(persons);

        // Exercise 1
        List<Person> erik = storage.findMany(p -> p.getFirstName().equals("Erik"));
        erik.forEach(System.out::println);


        // Exercise 2
        List<Person> females = storage.findMany(p -> p.getGender().equalsIgnoreCase("female"));
        females.forEach(System.out::println);

        // Exercise 3
        List<Person> bornAfter2000 = storage.findMany(p -> p.getBirthDate().isAfter(LocalDate.of(1999, 12, 31)));
        bornAfter2000.forEach(System.out::println);

        // Exercise 4
        Person person123 = storage.findOne(p -> p.getId() == 123);
        System.out.println(person123);



    }
}
