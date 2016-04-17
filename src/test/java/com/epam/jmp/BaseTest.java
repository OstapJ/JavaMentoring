package com.epam.jmp;

import com.epam.jmp.dao.TestSuite;
import com.epam.jmp.service.TestSuiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class BaseTest extends AbstractTestNGSpringContextTests
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
	Calculator calculator;

	/**
	 * There in an issue with integration Spring and TestNG. The ticket SPR-4072
	 * It is a workaround in order to load an application context before suite runs
	 * @throws Exception
	 */
	@BeforeSuite(groups = { "positive", "negative" })
	protected void setupSpringAutowiring() throws Exception {
		super.springTestContextBeforeTestClass();
		super.springTestContextPrepareTestInstance();
		TestSuite testSuite = (TestSuite) ApplicationContextProvider.getApplicationContext().getBean("testSuite");
		testSuite.setName("Initialize first empty Suite");
		TestSuiteService testSuiteService = (TestSuiteService) ApplicationContextProvider.getApplicationContext().getBean("testSuiteService");
		testSuiteService.add(testSuite);
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
}
