package com.epam.mentoring.pages;


import com.epam.mentoring.webdriver.WebDriverWrapperPool;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriverWrapperPool driver;

    public AbstractPage(WebDriverWrapperPool driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
