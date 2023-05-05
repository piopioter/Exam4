package org.exam.exercise5.app;

import org.exam.exercise5.exception.InvalidBirthDateException;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BirthDateRunner {
    public static void main(String[] args) throws InvalidBirthDateException {

        Scanner sc = new Scanner(System.in);
        String pattern = "dd/MM/yyyy";
        System.out.println("Podaj datę urodzenia dokładnie w takim schemacie: " + pattern);
        String date = sc.nextLine();
        parseToLocalDate(date, pattern);
        validateBirthDate(date, pattern);
        System.out.println("Żyjesz: " + getDaysSinceYourBorn(date, pattern) + "dni");
        System.out.println("Zyjesz: " + getMonthsSinceYourBorn(date, pattern) + "miesięcy");
        System.out.println("Zyjesz: " + getYearsSinceYourBorn(date, pattern) + "lat");
        System.out.println("Dzień urodzeniał: " + getDayOfBirth(date, pattern));
        System.out.println("Najbliższy piątek 13go: " + findNextFriday13thAfterBirth(date, pattern));
        sc.close();
    }

    private static LocalDate parseToLocalDate(String date, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, dtf);
    }

    public static void validateBirthDate(String date, String pattern) throws InvalidBirthDateException {
        LocalDate dateFromString = parseToLocalDate(date, pattern);
        if (dateFromString.isAfter(LocalDate.now())) {
            throw new InvalidBirthDateException("Nieprawidłowa data urodzenia");
        }
    }

    public static long getDaysSinceYourBorn(String date, String pattern) {
        LocalDate dateFromString = parseToLocalDate(date, pattern);
        return ChronoUnit.DAYS.between(dateFromString, LocalDate.now());

    }

    public static long getMonthsSinceYourBorn(String date, String pattern) {
        LocalDate dateFromString = parseToLocalDate(date, pattern);
        return ChronoUnit.MONTHS.between(YearMonth.from(dateFromString), YearMonth.from(LocalDate.now()));
    }

    public static long getYearsSinceYourBorn(String date, String pattern) {
        LocalDate dateFromString = parseToLocalDate(date, pattern);
        return ChronoUnit.YEARS.between(YearMonth.from(dateFromString), YearMonth.from(LocalDate.now()));
    }

    public static DayOfWeek getDayOfBirth(String date, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, dtf).getDayOfWeek();
    }

    public static LocalDate findNextFriday13thAfterBirth(String date, String pattern) {
        LocalDate dateFromString = parseToLocalDate(date, pattern);
        LocalDate localDate = dateFromString.withDayOfMonth(13);

        while ((localDate.isBefore(dateFromString) || localDate.isEqual(dateFromString))
                || (localDate.getDayOfWeek() != DayOfWeek.FRIDAY)) {
            localDate = localDate.plusMonths(1);
        }

        return localDate;

    }

}
