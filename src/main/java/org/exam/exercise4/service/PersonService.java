package org.exam.exercise4.service;

import org.exam.exercise4.exception.NoWomenException;
import org.exam.exercise4.model.Person;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PersonService {

    public static Person getOldestWoman(List<Person> personList) throws NoWomenException {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getName().endsWith("a"))
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow(() -> new NoWomenException("Brak elementów"));
    }

    public static double getAverageAgeOfAllPeople(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0);
    }

    private static double getMenAverageAge(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> !x.getName().endsWith("a"))
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0);
    }

    private static double getWomenAverageAge(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getName().endsWith("a"))
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0);
    }

    public static double getAverageAgeByGender(List<Person> personList, Supplier<Person.Gender> genderSupplier) {
        if (genderSupplier.get() == Person.Gender.FEMALE)
            return getWomenAverageAge(personList);
        else if (genderSupplier.get() == Person.Gender.MALE)
            return getMenAverageAge(personList);
        return 0;
    }

    public static String getCityWithLargestNumberOfPeople(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getCity() != null)
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new IllegalStateException("Brak danych"))
                .getKey();

    }

    public static List<String> getCities(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .map(Person::getCity)
                .distinct()
                .collect(Collectors.toList());

    }
}
