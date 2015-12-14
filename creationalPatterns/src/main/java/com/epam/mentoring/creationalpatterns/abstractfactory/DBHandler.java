package com.epam.mentoring.creationalpatterns.abstractfactory;

public interface DBHandler {
    Person readPerson();
    void writePerson(Person person);
}
