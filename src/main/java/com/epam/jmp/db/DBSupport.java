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
					"CREATE TABLE UnitTestCase (id INT not null primary key, className varchar(1000), testName varchar(1000), description varchar(4000), result varchar(1000), failReason varchar(1000), time INT)");
//					"CREATE TABLE UnitTestCase (id INT, time INT)");
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
