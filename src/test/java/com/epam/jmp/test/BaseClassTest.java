package com.epam.jmp.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.epam.jmp.listener.Calculator;

public class BaseClassTest
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseClassTest.class);

	protected Calculator calculator;

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

}
