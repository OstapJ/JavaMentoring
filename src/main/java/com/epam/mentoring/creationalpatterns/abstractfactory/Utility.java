package com.epam.mentoring.creationalpatterns.abstractfactory;

import java.io.InputStream;
import java.util.Properties;

public class Utility {

    public String getProperty(String propName){
        Properties property = new Properties();
        try {
            InputStream fis = getClass().getClassLoader()
                    .getResourceAsStream("db.properties");
            property.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Unable to find the property file", e);
        }
        return property.getProperty(propName);
    }


}
