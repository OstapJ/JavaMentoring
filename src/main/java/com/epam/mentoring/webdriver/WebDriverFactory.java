package com.epam.mentoring.webdriver;


import org.openqa.selenium.WebDriver;

public interface WebDriverFactory {

    /**
     * Creates new WebDriver instance
     */
    WebDriver createWebDriver();

}
