package com.company.reflection;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    static List<Person> personList = new ArrayList<>();

    public void add(Person person) {
        personList.add(person);
    }

    public List<Person> getPersons() {
        return personList;
    }
}
