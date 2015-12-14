package com.epam.mentoring.creationalpatterns.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileHandler implements DataHandler {

    private static final Logger logger = LoggerFactory.getLogger(FileHandler.class);
    private String filePath = "personInfo.txt";

    public Person readPerson() {
        Object obj = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)
        ) {
            obj = ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("Obtained the '{}' from the '{}' file", obj, filePath);
        return (Person)obj;
    }


    public void writePerson(Person person) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)
        ) {
            oos.writeObject(person);
            oos.close();
            logger.debug("The '{}' is written in the '{}' file", person, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
