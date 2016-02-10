package com.epam.mentoring.pages;

import com.epam.mentoring.webdriver.WebDriverWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    public MainPage(WebDriverWrapper driver) {
        super(driver);
    }

    @FindBy(css = "a[href='http://catalog.onliner.by/mobile'][class]")
    private WebElement mobilePhoneLink;

    @FindBy(css = "a[href='http://catalog.onliner.by/notebook'][class]")
    private WebElement laptopLink;

    @FindBy(css = "a[href='http://catalog.onliner.by/tabletpc'][class]")
    private WebElement tabletLink;

    public CatalogPage goToMobilePhoneCatalog() throws InterruptedException {
        mobilePhoneLink.click();
        return new CatalogPage(driver);
    }

    public CatalogPage goToLaptopCatalog() throws InterruptedException {
        laptopLink.click();
        return new CatalogPage(driver);
    }

    public CatalogPage goToTabletCatalog() throws InterruptedException {
        tabletLink.click();
        return new CatalogPage(driver);
    }
}
