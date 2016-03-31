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
					"CREATE TABLE UnitTestCase (id INT, className varchar2(1000), name varchar2(1000), test varchar2(1000), result varchar2(1000), message varchar2(4000), failReason varchar2(1000), evaluation varchar2(1000), time INT)");
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
			statement.executeUpdate("DROP TABLE Persons");
			connection.commit();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
