package com.epam.mentoring.creationalpatterns.abstractfactory;


public class Runner {

    public static void main(String[] args) {
        //launch only first time to create a table in the DB
//        new DBSupport().initiateDBStructure();
//        new DBSupport().cleanDB();
        Person person = new Person("Rita", 66);
        FileHandler textFileHandler = new TextFileManager().getFileHandler();
        textFileHandler.writePerson(person);
        Person personFromSource = textFileHandler.readPerson();
    }
}