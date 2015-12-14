package com.epam.mentoring.creationalpatterns.factorymethod;

public class Runner {

    public static void main(String[] args) {
        //launch only first time to create a table in the DB
//        new DBSupport().initiateDBStructure();
//        new DBSupport().cleanDB();

        Person person = new Person("Gena", 36);
        DataHandler fileHandler = DataManager.getDataHandler(StorageType.DATABASE);
        fileHandler.writePerson(person);
        Person personFromSource = fileHandler.readPerson();
    }
}

