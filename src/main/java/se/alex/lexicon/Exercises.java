package se.alex.lexicon;

import se.alex.lexicon.data.DataStorage;
import se.alex.lexicon.model.Gender;
import se.alex.lexicon.model.Person;

import java.time.LocalDate;
import java.util.Comparator;

public class Exercises {

    private static final DataStorage STORAGE = DataStorage.INSTANCE;

    public static void exercise1(String message) {
        System.out.println(message);
        STORAGE.findMany(p -> p.getFirstName().equals("Erik"))
                .forEach(System.out::println);
    }

    public static void exercise2(String message) {
        System.out.println(message);
        STORAGE.findMany(p -> p.getGender() == Gender.FEMALE)
                .forEach(System.out::println);
    }

    public static void exercise3(String message) {
        System.out.println(message);
        STORAGE.findMany(p -> p.getBirthDate().isAfter(LocalDate.of(1999, 12, 31)))
                .forEach(System.out::println);
    }

    public static void exercise4(String message) {
        System.out.println(message);
        Person person = STORAGE.findOne(p -> p.getId() == 123);
        System.out.println(person);
    }

    public static void exercise5(String message) {
        System.out.println(message);
        String personStr = STORAGE.findOneAndMapToString(
                p -> p.getId() == 456,
                p -> "Name: " + p.getFirstName() + " " + p.getLastName() + " born " + p.getBirthDate()
        );
        System.out.println(personStr);
    }

    public static void exercise6(String message) {
        System.out.println(message);
        STORAGE.findManyAndMapEachToString(
                p -> p.getGender() == Gender.MALE && p.getFirstName().startsWith("E"),
                p -> p.getFirstName() + " " + p.getLastName()
        ).forEach(System.out::println);
    }

    public static void exercise7(String message) {
        System.out.println(message);
        STORAGE.findManyAndMapEachToString(
                p -> p.getAge() < 10,
                p -> p.getFirstName() + " " + p.getLastName() + " " + p.getAge() + " years"
        ).forEach(System.out::println);
    }

    public static void exercise8(String message) {
        System.out.println(message);
        STORAGE.findAndDo(
                p -> p.getFirstName().equalsIgnoreCase("Ulf"),
                System.out::println
        );
    }

    public static void exercise9(String message) {
        System.out.println(message);
        STORAGE.findAndDo(
                p -> p.getLastName().contains(p.getFirstName()),
                System.out::println
        );
    }

    public static void exercise10(String message) {
        System.out.println(message);
        STORAGE.findAndDo(
                p -> new StringBuilder(p.getFirstName()).reverse().toString().equalsIgnoreCase(p.getFirstName()),
                p -> System.out.println(p.getFirstName() + " " + p.getLastName())
        );
    }

    public static void exercise11(String message) {
        System.out.println(message);
        STORAGE.findAndSort(
                p -> p.getFirstName().startsWith("A"),
                Comparator.comparing(Person::getBirthDate)
        ).forEach(System.out::println);
    }

    public static void exercise12(String message) {
        System.out.println(message);
        STORAGE.findAndSort(
                p -> p.getBirthDate().isBefore(LocalDate.of(1950, 1, 1)),
                Comparator.comparing(Person::getBirthDate).reversed()
        ).forEach(System.out::println);
    }

    public static void exercise13(String message) {
        System.out.println(message);
        STORAGE.findAndSort(
                p -> true,
                Comparator.comparing(Person::getLastName)
                        .thenComparing(Person::getFirstName)
                        .thenComparing(Person::getBirthDate)
        ).forEach(System.out::println);
    }
}
