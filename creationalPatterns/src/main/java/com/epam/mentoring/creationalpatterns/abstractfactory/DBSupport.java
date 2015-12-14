package com.epam.mentoring.creationalpatterns.abstractfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBSupport {

    private Utility utility = new Utility();

    public void initiateDBStructure(){
        try (Connection connection = DriverManager.getConnection(utility.getProperty("connection.url"));
             Statement statement = connection.createStatement()
        ) {
            Class.forName(utility.getProperty("connection.driver")).newInstance();
            statement.executeUpdate("CREATE TABLE Persons (id INT, pic blob(16M))");
            connection.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void cleanDB(){
        try (Connection connection = DriverManager.getConnection(utility.getProperty("connection.url"));
             Statement statement = connection.createStatement()
        ) {
            Class.forName(utility.getProperty("connection.driver")).newInstance();
            statement.executeUpdate("DROP TABLE Persons");
            connection.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
