package org.exam.exercise3.app;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalAndStreamRunner {
    public static void main(String[] args) {


        List<Integer> integerList = List.of(27, 10, 34, 50, 3, 43, 14, 30, 26, 57, 3, -100);
        List<Integer> fiveBiggestElements = getFiveBiggestElements(integerList);
        System.out.println(fiveBiggestElements);
    }

    public static List<Integer> getFiveBiggestElements(List<Integer> integerList) {
        return Optional.ofNullable(integerList)
                .orElseGet(Collections::emptyList)
                .stream()
                .sorted((x, y) -> Integer.compare(y, x))
                .limit(5)
                .collect(Collectors.toList());

    }
}
