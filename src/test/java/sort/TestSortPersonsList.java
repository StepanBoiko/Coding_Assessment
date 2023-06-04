package sort;

import org.junit.jupiter.api.Test;
import sort.SortPersonsList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSortPersonsList {

    SortPersonsList.sortingProcessor sortingProcessor = new SortPersonsList.sortingProcessor();

    @Test
    public void testE2E() {
        String expectFilePath = "dataFiles/testFiles/expTestFile.txt";
        String resultFilePath = "dataFiles/testFiles/resultFromTestFile.txt";
        String unsortedFilePath = "dataFiles/testFiles/unsortedTestFile.txt";

        List<SortPersonsList.Person> persons = sortingProcessor
                .createPersonList(sortingProcessor.readDataFromFile(unsortedFilePath));
        sortingProcessor.sortPersons(persons);
        sortingProcessor.writePersonsIntoFile(resultFilePath, persons);

        try {
            Path path1 = Paths.get(expectFilePath);
            Path path2 = Paths.get(resultFilePath);

            byte[] file1Bytes = Files.readAllBytes(path1);
            byte[] file2Bytes = Files.readAllBytes(path2);

            assertTrue(Arrays.equals(file1Bytes, file2Bytes));

        } catch (IOException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testSortingAlgorithmWithRandomPersons() {
        List<String> fullNamesList = Arrays.asList(
                "Janet Parsons",
                "Adonis Julius Archer",
                "Janet Parsons",
                "Boiko"
        );

        List<String> fullNamesExpList = Arrays.asList(
                "Adonis Julius Archer",
                "Boiko",
                "Janet Parsons",
                "Janet Parsons"
        );

        List<SortPersonsList.Person> persons = sortingProcessor.createPersonList(fullNamesList);
        sortingProcessor.sortPersons(persons);
        List<SortPersonsList.Person> expList = sortingProcessor.createPersonList(fullNamesExpList);

        assertEquals(expList.size(), persons.size());

        for (int i = 0; i < expList.size(); i++) {
            SortPersonsList.Person person1 = expList.get(i);
            SortPersonsList.Person person2 = persons.get(i);

            assertEquals(person1.getLastName(), person2.getLastName());
            assertEquals(person1.getGivenNames(), person2.getGivenNames());
        }
    }

    @Test
    public void testSortingAlgorithmWithSameLastNames() {
        List<String> fullNamesList = Arrays.asList(
                "Janet Archer",
                "Adonis Julius Archer",
                "Zanet Archer",
                "Archer"
        );

        List<String> fullNamesExpList = Arrays.asList(
                "Archer",
                "Adonis Julius Archer",
                "Janet Archer",
                "Zanet Archer"
        );

        List<SortPersonsList.Person> persons = sortingProcessor.createPersonList(fullNamesList);
        sortingProcessor.sortPersons(persons);
        List<SortPersonsList.Person> expList = sortingProcessor.createPersonList(fullNamesExpList);

        assertEquals(expList.size(), persons.size());

        for (int i = 0; i < expList.size(); i++) {
            SortPersonsList.Person person1 = expList.get(i);
            SortPersonsList.Person person2 = persons.get(i);

            assertEquals(person1.getLastName(), person2.getLastName());
            assertEquals(person1.getGivenNames(), person2.getGivenNames());
        }
    }

    @Test
    public void testSortingAlgorithmWithSameGivenAndLastNames() {
        List<String> fullNamesList = Arrays.asList(
                "Janet Archer",
                "Janet Boiko",
                "Janet Archer",
                "Janet Archer"
        );

        List<String> fullNamesExpList = Arrays.asList(
                "Janet Archer",
                "Janet Archer",
                "Janet Archer",
                "Janet Boiko"
        );

        List<SortPersonsList.Person> persons = sortingProcessor.createPersonList(fullNamesList);
        sortingProcessor.sortPersons(persons);
        List<SortPersonsList.Person> expList = sortingProcessor.createPersonList(fullNamesExpList);

        assertEquals(expList.size(), persons.size());

        for (int i = 0; i < expList.size(); i++) {
            SortPersonsList.Person person1 = expList.get(i);
            SortPersonsList.Person person2 = persons.get(i);

            assertEquals(person1.getLastName(), person2.getLastName());
            assertEquals(person1.getGivenNames(), person2.getGivenNames());
        }
    }

    @Test
    public void testSortingAlgorithmWithOnlyLastNames() {
        List<String> fullNamesList = Arrays.asList(
                "Strylinskiy",
                "Boiko",
                "Zinchenko",
                "Archer"
        );

        List<String> fullNamesExpList = Arrays.asList(
                "Archer",
                "Boiko",
                "Strylinskiy",
                "Zinchenko"
        );

        List<SortPersonsList.Person> persons = sortingProcessor.createPersonList(fullNamesList);
        sortingProcessor.sortPersons(persons);
        List<SortPersonsList.Person> expList = sortingProcessor.createPersonList(fullNamesExpList);

        assertEquals(expList.size(), persons.size());

        for (int i = 0; i < expList.size(); i++) {
            SortPersonsList.Person person1 = expList.get(i);
            SortPersonsList.Person person2 = persons.get(i);

            assertEquals(person1.getLastName(), person2.getLastName());
            assertEquals(person1.getGivenNames(), person2.getGivenNames());
        }
    }
}