package se.alex.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class DataStorageImpl {

    private List<Person> persons = new ArrayList<>();

    public DataStorageImpl(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> findMany(Predicate<Person> condition) {
        return persons.stream().filter(condition).collect(Collectors.toList());
    }

    public Person findOne(Predicate<Person> condition) {
        return persons.stream().filter(condition).findFirst().orElse(null);
    }

    public String findOneAndMapToString(Predicate<Person> condition, Function<Person, String> mapper) {
        return persons.stream().filter(condition).map(mapper).findFirst().orElse(null);
    }

    public List<String> findManyAndMapEachToString(Predicate<Person> condition, Function<Person, String> mapper) {
        return persons.stream().filter(condition).map(mapper).collect(Collectors.toList());
    }

    public void findAndDo(Predicate<Person> condition, Consumer<Person> consumer) {
        persons.stream().filter(condition).forEach(consumer);
    }

    public List<Person> findAndSort(Predicate<Person> condition, Function<List<Person>, List<Person>> sorter) {
        List<Person> filtered = persons.stream().filter(condition).collect(Collectors.toList());
        return sorter.apply(filtered);
    }
}
