package sort;


import java.io.*;
import java.util.*;

public class SortPersonsList {

    static class Person {

        private List<String> givenNames;
        private String lastName;

        public Person(List<String> givenNames, String lastName) {
            this.givenNames = givenNames;
            this.lastName = lastName;
        }

        public List<String> getGivenNames() {
            return givenNames;
        }

        public String getLastName() {
            return lastName;
        }
    }

    static class sortingProcessor {

        public List<String> readDataFromFile(String unsortedFilePath) {
            List<String> fullNames = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(unsortedFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    fullNames.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            fullNames.forEach(System.out::println);

            return fullNames;
        }

        public List<Person> createPersonList(List<String> fullNamesList) {
            List<Person> persons = new ArrayList<>();

            for (String fullName : fullNamesList) {
                String[] parts = fullName.split(" ");
                List<String> givenNames = new ArrayList<>(Arrays.asList(parts));
                String lastName = givenNames.remove(givenNames.size() - 1);
                persons.add(new Person(givenNames, lastName));
            }
            return persons;
        }

        public void sortPersons(List<Person> persons) {
            Collections.sort(persons, new Comparator<Person>() {
                @Override
                public int compare(Person person1, Person person2) {
                    int lastNameComparison = person1.getLastName().compareTo(person2.getLastName());
                    if (lastNameComparison != 0) {
                        return lastNameComparison;
                    } else {
                        List<String> givenNamesPerson1 = person1.getGivenNames();
                        List<String> givenNamesPerson2 = person2.getGivenNames();
                        int shortestGivenName = Math.min(givenNamesPerson1.size(), givenNamesPerson2.size());
                        for (int i = shortestGivenName - 1; i >= 0; i--) {
                            String givenName1 = givenNamesPerson1.get(i);
                            String givenName2 = givenNamesPerson2.get(i);
                            int givenNameComparison = givenName1.compareTo(givenName2);
                            if (givenNameComparison != 0) {
                                return givenNameComparison;
                            }
                        }
                        return givenNamesPerson1.size() - givenNamesPerson2.size();
                    }
                }
            });
        }

        public File writePersonsIntoFile (String resultFilePath, List<Person> sortedPersonsList) {
            File resultFile = new File(resultFilePath);
             try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
                 boolean isFirst = true;

                 for (Person person : sortedPersonsList) {
                     if (isFirst) {
                         writer.write(person.getGivenNames().toString()
                                 .replace("[", "")
                                 .replace("]", "")
                                 .replace(",", "") + " ");
                         writer.write(person.getLastName());
                         isFirst = false;

                     } else {
                         writer.newLine();
                         writer.write(person.getGivenNames().toString()
                                 .replace("[", "")
                                 .replace("]", "")
                                 .replace(",", "") + " ");
                         writer.write(person.getLastName());
                     }
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return resultFile;
        }

        public void processRun(String firstfilePath, String filePathResult) {
            List<Person> persons = createPersonList(readDataFromFile(firstfilePath));

            System.out.println("\n\nBefore Sorting:\n");
            for (Person person : persons) {
                System.out.println("Given Names: " + person.getGivenNames() + ", Last Name: " + person.getLastName());
            }

            sortPersons(persons);
            writePersonsIntoFile(filePathResult, persons);

            System.out.println("\n\nAfter Sorting:\n");
            for (Person person : persons) {
                System.out.println("Given Names: " + person.getGivenNames() + ", Last Name: " + person.getLastName());
            }
        }
    }
}

