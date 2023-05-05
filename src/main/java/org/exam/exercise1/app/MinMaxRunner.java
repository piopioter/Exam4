package org.exam.exercise1.app;

import org.exam.exercise1.model.MinMax;
import org.exam.exercise1.model.Person;
import org.exam.exercise1.service.MinMaxService;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {


        List<Integer> integerList = List.of(23, 45, 19, 34, 4, 2, 6);

        MinMax<Integer> minAndMax = MinMaxService.getMinAndMax(integerList);

        System.out.println(minAndMax.getMax());
        System.out.println(minAndMax.getMin());
        List<String> stringList = new ArrayList<>();
        stringList.add("string");
        stringList.add("strin");
        stringList.add("stri");
        stringList.add("str");
        stringList.add("st");


        MinMax<String> minMax = MinMaxService.getMinAndMax(stringList);
        System.out.println(minMax.getMax());
        System.out.println(minMax.getMin());


        List<Person> personList = new ArrayList<>();
        personList.add(new Person("paweł","gil"));
        personList.add(new Person("jan","gil"));
        personList.add(new Person("łukasz","buc"));
        personList.add(new Person("michał","janusz"));
        personList.add(new Person("mateusz","michal"));

        MinMax<Person> personMinMax = MinMaxService.getMinAndMax(personList);

        System.out.println(personMinMax.getMax());
        System.out.println(personMinMax.getMin());

        List<Integer> list = new LinkedList<>();
        MinMax<Integer> minAndMax1 = MinMaxService.getMinAndMax(list);
        System.out.println(minAndMax1.getMin());
        System.out.println(minAndMax1.getMax());
    }
}
