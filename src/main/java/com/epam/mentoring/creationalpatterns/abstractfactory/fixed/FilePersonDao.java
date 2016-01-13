package com.epam.mentoring.creationalpatterns.abstractfactory.fixed;

import com.epam.mentoring.creationalpatterns.abstractfactory.Person;

/**
 * Created by andrei_varabyeu on 1/13/16.
 */
public class FilePersonDao implements PersonDao {
    @Override public Person getPersons() {
        return null;
    }

    @Override public Person getPerson(String name) {
        return null;
    }

    @Override public void writePerson() {

    }
}
