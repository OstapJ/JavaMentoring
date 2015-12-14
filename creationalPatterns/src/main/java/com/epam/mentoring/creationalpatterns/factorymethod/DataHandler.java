package com.epam.mentoring.creationalpatterns.factorymethod;

public interface DataHandler {

    Person readPerson();
    void writePerson(Person person);
}
