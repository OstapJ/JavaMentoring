package com.epam.jmp.pages;

import com.epam.jmp.webdriver.WebDriverWrapperPool;
import org.openqa.selenium.By;

public class MainPage extends AbstractPage {

    public MainPage(WebDriverWrapperPool driver) {
        super(driver);
    }

    public CatalogPage goToMobilePhoneCatalog() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href='http://catalog.onliner.by/mobile'][class]")).click();
        return new CatalogPage(driver);
    }

    public CatalogPage goToLaptopCatalog() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href='http://catalog.onliner.by/notebook'][class]")).click();
        return new CatalogPage(driver);
    }

    public CatalogPage goToTabletCatalog() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href='http://catalog.onliner.by/tabletpc'][class]")).click();
        return new CatalogPage(driver);
    }
}
