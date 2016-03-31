package com.epam.jmp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBSupport
{

	private Utility utility = new Utility();

	public void initiateDBStructure()
	{
		try (Connection connection = DriverManager.getConnection(utility.getProperty("connection.url"));
				Statement statement = connection.createStatement()
		)
		{
			Class.forName(utility.getProperty("connection.driver")).newInstance();
			statement.executeUpdate(
					"CREATE TABLE UnitTestCase (id INT, className varchar(1000), name varchar(1000), test varchar(1000), result BOOLEAN, message varchar(4000), failReason varchar(1000), evaluation varchar(1000), time LONG)");
			connection.commit();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void cleanDB()
	{
		try (Connection connection = DriverManager.getConnection(utility.getProperty("connection.url"));
				Statement statement = connection.createStatement()
		)
		{
			Class.forName(utility.getProperty("connection.driver")).newInstance();
			statement.executeUpdate("DROP TABLE UnitTestCase");
			connection.commit();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
