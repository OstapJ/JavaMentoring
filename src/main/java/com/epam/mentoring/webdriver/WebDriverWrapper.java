package com.epam.mentoring.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class WebDriverWrapper implements WebDriver {


    private final static Logger LOGGER = LoggerFactory.getLogger(WebDriverWrapper.class);
    private WebDriver webDriver;
    private String browserName;
    private static List<WebDriverWrapper> AllBrowserInstances = new LinkedList<WebDriverWrapper>();


    private static ThreadLocal<Map<String, WebDriverWrapper>> instancesCache = new ThreadLocal<Map<String, WebDriverWrapper>>() {
        @Override
        protected java.util.Map<String, WebDriverWrapper> initialValue() {
            return new HashMap<>();
        }
    };

    private static void clearCache() {
        Map<String, WebDriverWrapper> instances = instancesCache.get();
        for (Map.Entry<String, WebDriverWrapper> entry : instances.entrySet()) {
            LOGGER.debug("Quit WebDriverWrapper with name '" + entry.getKey() + "'");
            entry.getValue().quit();
            AllBrowserInstances.remove(entry.getValue());
        }
        instances.clear();
    }


    public static synchronized void quitAll() {
        clearCache();
        LOGGER.debug("Browsers in full cache " + AllBrowserInstances.size());
        for (WebDriverWrapper WebDriverWrapper : AllBrowserInstances) {
            LOGGER.debug("Closing WebDriverWrapper with name " + WebDriverWrapper.getBrowserName());
            WebDriverWrapper.quit();
        }
        AllBrowserInstances.clear();
    }

    /**
     * Uses provided Web Driver Factory for producing instances
     *
     * @param name - Name of webDriver
     */
    private WebDriverWrapper(String name, WebDriverFactory webDriverFactory) {
        this.browserName = name;
        LOGGER.info("Create WebDriverWrapper instance with name '" + name + "' using " + webDriverFactory.getClass().getSimpleName()
                + " in Thread '" + Thread.currentThread().getName() + "', ID '" + Thread.currentThread().getId() + "'");
        this.webDriver = webDriverFactory.createWebDriver();

        try {
            manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        } catch (WebDriverException e) {
            LOGGER.error("Unable to change page load timeout", e);
        }

        AllBrowserInstances.add(this);

    }


    private static String appendFactoryHash(String browserName, WebDriverFactory webDriverFactory) {
        return browserName + "- " + webDriverFactory.hashCode();
    }

    /**
     * Returns instance for specified name
     *
     * @param name
     * @param webDriverFactory
     * @return
     */
    public static WebDriverWrapper getInstance(String name, WebDriverFactory webDriverFactory) {
        WebDriverWrapper webDriverWrapper = getInstanceFromCache(name, webDriverFactory);

        if (null == webDriverWrapper) {
            webDriverWrapper = new WebDriverWrapper(name, webDriverFactory);
            instancesCache.get().put(appendFactoryHash(name, webDriverFactory), webDriverWrapper);
            return webDriverWrapper;
        } else {
            boolean isReachable = isBrowserReachable(webDriverWrapper);
            if (!isReachable) {
                webDriverWrapper.quit();
                webDriverWrapper = new WebDriverWrapper(name, webDriverFactory);
                instancesCache.get().put(appendFactoryHash(name, webDriverFactory), webDriverWrapper);
                return webDriverWrapper;
            }
        }
        return webDriverWrapper;
    }

    private static boolean isBrowserReachable(WebDriverWrapper WebDriverWrapper) {
        if (WebDriverWrapper.getWebDriver() instanceof RemoteWebDriver) {
            RemoteWebDriver remoteWd = (RemoteWebDriver) WebDriverWrapper.getWebDriver();
            try {
                return !(null == remoteWd.getSessionId() || null == remoteWd.getWindowHandle());
            } catch (UnreachableBrowserException e) {
                return false;
            }
        }
        return true;

    }

    public static WebDriverWrapper getInstanceFromCache(String name, WebDriverFactory webDriverFactory) {
        Map<String, WebDriverWrapper> currentThreadInstancesCache = instancesCache.get();
        String currentFactoryBrowserName = appendFactoryHash(name, webDriverFactory);
        return currentThreadInstancesCache.get(currentFactoryBrowserName);
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

    public  void waitForElementIsVisible(WebElement element) {
        (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.visibilityOf(element));
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
    public WebElement findElement(By by) {
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
        try {
            webDriver.quit();
        } catch (Exception e) {
        }
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

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
