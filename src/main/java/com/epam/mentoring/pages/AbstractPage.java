package com.epam.mentoring.pages;


import com.epam.mentoring.webdriver.WebDriverWrapper;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriverWrapper driver;

    public AbstractPage(WebDriverWrapper driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
