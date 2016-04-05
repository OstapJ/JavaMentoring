package com.epam.jmp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseClassTest
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseClassTest.class);

	private EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	protected Calculator calculator;

	public static EntityManager getEntityManager()
	{
		return entityManager;
	}

	@BeforeSuite(groups = { "positive", "negative" })
	public void initializeDBEntities()
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("test");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@BeforeClass(groups = { "positive" })
	public void initializeCalculator()
	{
		calculator = new Calculator();
	}

	@BeforeClass(groups = "negative")
	public void createCalculator()
	{
		calculator = new Calculator();
	}

	@AfterClass(groups = "positive")
	public void printPositiveOperationFinish()
	{
		LOGGER.info("POSITIVE OPERATION IS DONE");
	}

	@AfterClass(groups = "negative")
	public void printNegativeOperationFinish()
	{
		LOGGER.info("NEGATIVE OPERATION IS DONE");
	}


	@AfterSuite(groups = { "positive", "negative" })
	public void cleanUpDBEntities()
	{
//		entityManager.close();
//		entityManagerFactory.close();
	}
}
