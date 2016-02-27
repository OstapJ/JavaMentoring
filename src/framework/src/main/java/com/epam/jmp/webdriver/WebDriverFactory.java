package com.epam.jmp.webdriver;


import org.openqa.selenium.WebDriver;

public interface WebDriverFactory {

    /**
     * Creates new WebDriver instance
     */
    WebDriver createWebDriver();

}
