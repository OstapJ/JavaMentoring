package com.epam.mentoring.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebDriverWrapperPool extends BrowserPool implements WebDriver {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebDriverWrapperPool.class);
    private WebDriver webDriver;
    private String browserName;
    private WebDriverFactory webDriverFactory;
    private static List<WebDriverWrapperPool> AllBrowserInstances = new LinkedList<>();

    public WebDriverWrapperPool(int size) {
        super(size);
    }

    public synchronized WebDriverWrapperPool getInstance(String name, WebDriverFactory webDriverFactory) throws Exception {
        this.browserName = name;
        this.webDriverFactory = webDriverFactory;
        return (WebDriverWrapperPool) borrow();
    }

    @Override
    public WebDriver createObject() {
        LOGGER.info("Create WebDriverWrapper instance with name '" + browserName + "' using " + webDriverFactory.getClass().getSimpleName()
                + " in Thread '" + Thread.currentThread().getName() + "', ID '" + Thread.currentThread().getId() + "'");
        this.webDriver = webDriverFactory.createWebDriver();
        try {
            manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            manage().window().maximize();
        } catch (WebDriverException e) {
            LOGGER.error("Unable to change page load timeout", e);
        }
        AllBrowserInstances.add(this);
        return this;
    }


    public void back() throws Exception {
        returnBack(this);
    }


    public void quitAll() {
        LOGGER.debug("Browsers in full cache " + AllBrowserInstances.size());
        for (WebDriverWrapperPool WebDriverWrapper : AllBrowserInstances) {
            LOGGER.debug("Closing WebDriverWrapper. Size is '{}'" + WebDriverWrapper.getBrowserName(), AllBrowserInstances.size());
            WebDriverWrapper.quit();
        }
        AllBrowserInstances.clear();
    }

    @Override
    public void get(String url) {
        try {
            webDriver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }


    @Override
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webDriver.findElements(by);
    }

    @Override
    public WebElement findElement(final By by) {
        return webDriver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        webDriver.close();
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return webDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return webDriver.navigate();
    }

    @Override
    public Options manage() {
        return webDriver.manage();
    }

    public String getBrowserName() {
        return browserName;
    }
}