package com.epam.mentoring.creationalpatterns.abstractfactory.fixed;

/**
 * Created by andrei_varabyeu on 1/13/16.
 */
public class FilePersonDaoFactory implements PersonDaoFactory {
    @Override
    public PersonDaoFactory getPersonDao() {
        return new FilePersonDaoFactory();
    }
}
