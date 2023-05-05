package org.exam.exercise4.app;

import org.exam.exercise4.exception.NoWomenException;
import org.exam.exercise4.model.Person;
import org.exam.exercise4.service.PersonService;

import java.util.List;

public class PersonRunner {
    public static void main(String[] args) throws NoWomenException {

        List<Person> personList = List.of(
                new Person("Jan", "Kowalski", "Krakow", 47),
                new Person("Weronika", "Dąbrowska", "Szczecin", 19),
                new Person("Marek", "Grabowski", "Gdynia", 36),
                new Person("Iwona", "Kwiatkowska", "Lublin", 42),
                new Person("Damian", "Cieślak", "Warszawa", 27),
                new Person("Agnieszka", "Witkowska", "Poznan", 31),
                new Person("Michał", "Krupa", "Krakow", 45),
                new Person("Beata", "Górska", null, 53),
                new Person("Grzegorz", "Lewandowski", "Katowice", 39),
                new Person("Karolina", "Kowalczyk", "Katowice", 24),
                new Person("Kamil", "Sobczak", "Torun", 33),
                new Person("Dorota", "Szczepańska", "Bydgoszcz", 48),
                new Person("Szymon", "Kowalewski", "Gdansk", 21),
                new Person("Martyna", "Nowicka", "Krakow", 26),
                new Person("Tadeusz", "Majewski", "Warszawa", 30)

        );

        System.out.println(PersonService.getCities(personList));
        System.out.println(PersonService.getCityWithLargestNumberOfPeople(personList));
        System.out.println(PersonService.getOldestWoman(personList));
        System.out.println(PersonService.getAverageAgeOfAllPeople(personList));
        System.out.println(PersonService.getAverageAgeByGender(personList, () -> Person.Gender.MALE));

    }
}
