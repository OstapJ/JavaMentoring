package com.epam.mentoring.creationalpatterns.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;

public class DBHandler implements DataHandler {

    private static final Logger logger = LoggerFactory.getLogger(FileHandler.class);

    Utility utility = new Utility();
    private static int increment;

    public Person readPerson() {
        Object obj = null;
        try (Connection connection = DriverManager.getConnection(utility.getProperty("connection.url"));
             Statement statement = connection.createStatement()
        ) {
            Class.forName(utility.getProperty("connection.driver")).newInstance();
            ResultSet rs = statement.executeQuery(
                    "SELECT * FROM Persons WHERE id = " + increment);
            while (rs.next()) {
                java.sql.Blob ablob = rs.getBlob(2);
                ByteArrayInputStream byteInputStream = new ByteArrayInputStream(ablob.getBytes(1, (int) ablob.length()));
                ObjectInputStream objOutStream = new ObjectInputStream(byteInputStream);
                obj = objOutStream.readObject();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.debug("Obtained the '{}' from the DB", obj);
        return (Person) obj;
    }

    public void writePerson(Person person) {
        try (
                ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                ObjectOutputStream objOutStream = new ObjectOutputStream(byteOutStream);
                Connection connection = DriverManager.getConnection(utility.getProperty("connection.url"));
                Statement statement = connection.createStatement()) {
            Class.forName(utility.getProperty("connection.driver")).newInstance();
            objOutStream.writeObject(person);
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO Persons VALUES (?, ?)");
            ps.setInt(1, ++increment);
            ps.setBytes(2, byteOutStream.toByteArray());
            ps.execute();
            connection.commit();
            logger.debug("The '{}' is written into DB", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
