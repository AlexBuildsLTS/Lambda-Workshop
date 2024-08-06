package se.alex.lexicon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReader {

    private static final CSVReader INSTANCE;

    static {
        INSTANCE = new CSVReader();
    }

    private CSVReader() {
    }

    public static CSVReader getInstance() {
        return INSTANCE;
    }

    public List<String> getMaleFirstNames() {
        return readNamesFromFile("firstname_males.txt");
    }

    public List<String> getFemaleFirstNames() {
        return readNamesFromFile("firstname_female.txt");
    }

    public List<String> getLastNames() {
        return readNamesFromFile("lastnames.txt");
    }

    private List<String> readNamesFromFile(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            return reader.lines()
                    .flatMap(line -> Stream.of(line.split(",")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Handle this more gracefully in a real application
        }
    }
}
