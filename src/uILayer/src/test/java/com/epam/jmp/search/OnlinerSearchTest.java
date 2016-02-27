package com.epam.jmp.search;

import com.epam.jmp.pages.CatalogPage;
import com.epam.jmp.pages.MainPage;
import com.epam.jmp.utilz.PropertiesProvider;
import com.epam.jmp.webdriver.BrowserType;
import com.epam.jmp.webdriver.WebDriverFactoryManager;
import com.epam.jmp.webdriver.WebDriverWrapperPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

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

	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		driver.getInstance("Chrome", manager.createWebDriverFactory(BrowserType.CHROME));
		String baseUrl = prop.getProperties("baseUrl");
		driver.get(baseUrl);
	}

	@Test
	public void testSearchMobilePhone() throws InterruptedException
	{
		LOGGER.info("testSearchMobilePhone and Thread ID # " + Thread.currentThread().getId());
		MainPage mainPage = new MainPage(driver);
		CatalogPage catalogPage = mainPage.goToMobilePhoneCatalog();
		catalogPage.searchItem("Apple");
		Thread.sleep(1500);
		Assert.assertTrue(catalogPage.getFoundItem().contains("Apple"),
				"The found phone is " + catalogPage.getFoundItem());
	}

	@Test
	public void testSearchLaptop() throws InterruptedException
	{
		LOGGER.info("testSearchLaptop and Thread ID # " + Thread.currentThread().getId());
		MainPage mainPage = new MainPage(driver);
		CatalogPage catalogPage = mainPage.goToLaptopCatalog();
		catalogPage.searchItem("Apple");
		Thread.sleep(1500);
		Assert.assertTrue(catalogPage.getFoundItem().contains("Apple"),
				"The found laptop is " + catalogPage.getFoundItem());
	}

	@Test
	public void testTabletLaptop() throws InterruptedException
	{
		LOGGER.info("testTabletLaptop and Thread ID # " + Thread.currentThread().getId());
		MainPage mainPage = new MainPage(driver);
		CatalogPage catalogPage = mainPage.goToTabletCatalog();
		catalogPage.searchItem("Apple");
		Thread.sleep(1500);
		Assert.assertTrue(catalogPage.getFoundItem().contains("Apple"),
				"The found tablet is " + catalogPage.getFoundItem());
	}

	@AfterMethod
	public void clearUp() throws Exception
	{
		driver.back();
	}

	@AfterSuite
	public void quit() throws Exception
	{
		driver.quitAll();
	}
}
