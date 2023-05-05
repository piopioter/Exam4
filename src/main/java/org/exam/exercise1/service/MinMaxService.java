package org.exam.exercise1.service;

import org.exam.exercise1.model.MinMax;

import java.util.List;

public class MinMaxService {

    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {

        if (elements == null || elements.isEmpty())
            throw new IllegalStateException("Brak elementu");
        else {
            T min = elements.get(0);
            T max = elements.get(0);
            for (T element : elements) {
                if (element.compareTo(min) < 0)
                    min = element;
                else if (element.compareTo(max) > 0) {
                    max = element;
                }
            }

            return new MinMax<>(min, max);
        }
    }
}
