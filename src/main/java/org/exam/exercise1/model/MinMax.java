package org.exam.exercise1.model;

import java.util.Comparator;

public class MinMax<T extends Comparable<T>>  {
    private T min;
    private T max;

    public MinMax(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }
}
