package com.epam.mentoring.tests;

import com.epam.mentoring.pages.CatalogPage;
import com.epam.mentoring.pages.MainPage;
import com.epam.mentoring.utilz.PropertiesProvider;
import com.epam.mentoring.webdriver.BrowserType;
import com.epam.mentoring.webdriver.WebDriverFactoryManager;
import com.epam.mentoring.webdriver.WebDriverWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;


public class OnlinerSearchTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(OnlinerSearchTest.class);

    WebDriverWrapper driver;
    WebDriverFactoryManager manager;
    PropertiesProvider prop;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        LOGGER.info("beforeSuite and Thread ID # " + Thread.currentThread().getId());
        manager = new WebDriverFactoryManager();
        prop = new PropertiesProvider();
        manager.setChromeBinary(prop.getProperties("chromeBinary"));
    }

    @BeforeMethod
    public void beforeMethod() throws IOException {
        LOGGER.info("beforeMethod and Thread ID # " + Thread.currentThread().getId());
        driver = WebDriverWrapper.getInstance("Chrome", manager.createWebDriverFactory(BrowserType.CHROME));
        String baseUrl = prop.getProperties("baseUrl");
        driver.get(baseUrl);
    }

    @Test
    public void testSearchMobilePhone() throws InterruptedException {
        LOGGER.info("testSearchMobilePhone and Thread ID # " + Thread.currentThread().getId());
        MainPage mainPage = new MainPage(driver);
        CatalogPage catalogPage = mainPage.goToMobilePhoneCatalog();
        catalogPage.searchItem("Apple");
        Assert.assertTrue(catalogPage.getFoundItem().contains("Apple"), "The found phone is " + catalogPage.getFoundItem());
    }

    @Test
    public void testSearchLaptop() throws InterruptedException {
        LOGGER.info("testSearchLaptop and Thread ID # " + Thread.currentThread().getId());
        MainPage mainPage = new MainPage(driver);
        CatalogPage catalogPage = mainPage.goToLaptopCatalog();
        catalogPage.searchItem("Apple");
        Assert.assertTrue(catalogPage.getFoundItem().contains("Apple"), "The found laptop is " + catalogPage.getFoundItem());
    }

    @Test
    public void testTabletLaptop() throws InterruptedException {
        LOGGER.info("testTabletLaptop and Thread ID # " + Thread.currentThread().getId());
        MainPage mainPage = new MainPage(driver);
        CatalogPage catalogPage = mainPage.goToTabletCatalog();
        catalogPage.searchItem("Apple");
        Assert.assertTrue(catalogPage.getFoundItem().contains("Apple"), "The found tablet is " + catalogPage.getFoundItem());
    }


    @AfterSuite
    public void quit() {
        LOGGER.info("AfterSuite and Thread ID # " + Thread.currentThread().getId());
        WebDriverWrapper.quitAll();
    }
}
