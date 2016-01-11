package com.epam.mentoring.creationalpatterns.abstractfactory;

public interface FileHandler {

    Person readPerson();
    void writePerson(Person person);
}
