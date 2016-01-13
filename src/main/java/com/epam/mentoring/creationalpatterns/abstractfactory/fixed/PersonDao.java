package com.epam.mentoring.creationalpatterns.abstractfactory.fixed;

import com.epam.mentoring.creationalpatterns.abstractfactory.Person;

/**
 * Created by andrei_varabyeu on 1/13/16.
 */
public interface PersonDao {
    Person getPersons();
    Person getPerson(String name);
    void writePerson();
}
