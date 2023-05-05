package org.exam.exercise1.model;

public class Person implements Comparable<Person> {
    private String name;
    private String lastname;

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


    @Override
    public int compareTo(Person o) {
        int result = lastname.compareTo(o.lastname);
        if (result == 0)
            result = name.compareTo(o.name);
        return result;
    }
}
