package se.alex.lexicon;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person(123, "Erik", "Eriksson", LocalDate.parse("2000-01-01"), "Male"),
                new Person(124, "Anna", "Andersson", LocalDate.parse("1990-05-12"), "Female")

        );

        DataStorageImpl storage = new DataStorageImpl(persons);

        List<Person> eriks = storage.findMany(p -> p.getFirstName().equals("Erik"));
        eriks.forEach(System.out::println);
    }
}
