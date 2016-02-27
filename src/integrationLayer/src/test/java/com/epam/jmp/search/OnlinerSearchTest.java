package com.epam.jmp.search;

import com.epam.jmp.utilz.PropertiesProvider;
import com.epam.jmp.webdriver.WebDriverFactoryManager;
import com.epam.jmp.webdriver.WebDriverWrapperPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class OnlinerSearchTest
{

	private final static Logger LOGGER = LoggerFactory.getLogger(OnlinerSearchTest.class);

	WebDriverWrapperPool driver;
	WebDriverFactoryManager manager;
	PropertiesProvider prop;

	@BeforeSuite
	public void beforeSuite() throws IOException
	{
		LOGGER.info("beforeSuite and Thread ID # " + Thread.currentThread().getId());
		manager = new WebDriverFactoryManager();
		prop = new PropertiesProvider();
		manager.setChromeBinary(prop.getProperties("chromeBinary"));
		driver = new WebDriverWrapperPool(1);
	}
}
