package org.exam.exercise2.app;

import org.exam.exercise2.exception.InvalidPeselException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class OptionalRunner {
    public static void main(String[] args) throws InvalidPeselException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj imię");
        String name = sc.nextLine();
        getNameLength(name);
        System.out.println("Podaj  pesel");
        String pesel = sc.nextLine();
        System.out.println(getBirthDateFromPesel(pesel));
        sc.close();

    }

    public static void getNameLength(String name) {
        Optional.ofNullable(name)
                .ifPresentOrElse(x -> System.out.println(x.length()), () -> System.out.println(0));
    }

    public static String getBirthDateFromPesel(String pesel) throws InvalidPeselException {
        return Optional.ofNullable(pesel)
                .filter(x -> x.length() == 11)
                .map(x -> x.substring(0, 6))
                .orElseThrow(() -> new InvalidPeselException("Nie prawidłowy pesel"));
    }
}
