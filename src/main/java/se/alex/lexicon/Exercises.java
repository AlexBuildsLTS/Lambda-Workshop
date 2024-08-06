package se.alex.lexicon;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        // Exercise 5
        String person456 = storage.findOneAndMapToString(
                p -> p.getId() == 456,
                p -> "Name: " + p.getFirstName() + " " + p.getLastName() + " born " + p.getBirthDate()
        );
        System.out.println(person456);

        // Exercise 6
        List<String> malesStartingWithE = storage.findManyAndMapEachToString(
                p -> p.getGender().equalsIgnoreCase("Male") && p.getFirstName().startsWith("E"),
                p -> p.getFirstName() + " " + p.getLastName()
        );
        malesStartingWithE.forEach(System.out::println);

        // Exercise 7
        List<String> belowAge10 = storage.findManyAndMapEachToString(
                p -> p.getBirthDate().isAfter(LocalDate.now().minusYears(10)),
                p -> p.getFirstName() + " " + p.getLastName() + " " + (LocalDate.now().getYear() - p.getBirthDate().getYear()) + " years"
        );
        belowAge10.forEach(System.out::println);

        // Exercise 8
        storage.findAndDo(
                p -> p.getFirstName().equals("Ulf"),
                p -> System.out.println(p)
        );

        // Exercise 9
        storage.findAndDo(
                p -> p.getLastName().contains(p.getFirstName()),
                p -> System.out.println(p)
        );

        // Exercise 10
        storage.findAndDo(
                p -> new StringBuilder(p.getFirstName()).reverse().toString().equals(p.getFirstName()),
                p -> System.out.println(p.getFirstName() + " " + p.getLastName())
        );

        // Exercise 11
        List<Person> startsWithA = storage.findAndSort(
                p -> p.getFirstName().startsWith("A"),
                list -> list.stream().sorted((p1, p2) -> p1.getBirthDate().compareTo(p2.getBirthDate())).collect(Collectors.toList())
        );
        startsWithA.forEach(System.out::println);

        // Exercise 12
        List<Person> bornBefore1950 = storage.findAndSort(
                p -> p.getBirthDate().isBefore(LocalDate.of(1950, 1, 1)),
                list -> list.stream().sorted((p1, p2) -> p2.getBirthDate().compareTo(p1.getBirthDate())).collect(Collectors.toList())
        );
        bornBefore1950.forEach(System.out::println);

        // Exercise 13
        List<Person> sortedByLastNameFirstNameBirthdate = storage.findAndSort(
                p -> true,
                list -> list.stream()
                        .sorted((p1, p2) -> {
                            int lastNameComparison = p1.getLastName().compareTo(p2.getLastName());
                            if (lastNameComparison != 0) return lastNameComparison;
                            int firstNameComparison = p1.getFirstName().compareTo(p2.getFirstName());
                            if (firstNameComparison != 0) return firstNameComparison;
                            return p1.getBirthDate().compareTo(p2.getBirthDate());
                        })
                        .collect(Collectors.toList())
        );
        sortedByLastNameFirstNameBirthdate.forEach(System.out::println);
    }
}
