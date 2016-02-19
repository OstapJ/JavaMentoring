package com.epam.mentoring.pages;

import com.epam.mentoring.webdriver.WebDriverWrapperPool;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


public class CatalogPage extends AbstractPage {

    public CatalogPage(WebDriverWrapperPool driver) throws InterruptedException {
        super(driver);
    }

    @FindBy(css = "[class='schema-filter__facet']:nth-of-type(2) span[data-bind='html: item.name'][class='schema-filter__checkbox-text']")
    private List<WebElement> mobilePhoneLables;

    @FindBy(css = "ul[class='schema-filter__list'] input[type='checkbox'][value]~span")
    private List<WebElement> mobilePhoneCheckboxes;


    @FindBy(css = "div[class='schema-product__title']")
    private List<WebElement> mobilePhoneSummaryLables;

    @FindBy(css = "span[class='schema-tags__text']")
    private WebElement filterLabel;

    @FindBy(id = "schema-products")
    protected WebElement downloadingIndicator;


    public void searchItem(String model) throws InterruptedException {
        int itemIndex = -1;
        Thread.sleep(1000);
        for (int i = 0; i < mobilePhoneLables.size(); i++) {
            if (mobilePhoneLables.get(i).getText().equals(model)) {
                itemIndex = i;
                break;
            }
        }
        Assert.assertTrue(itemIndex != -1, "There aren't any checkboxes with " + model + " name");
        mobilePhoneCheckboxes.get(itemIndex).click();
    }

    public String getFoundItem() {
        return mobilePhoneSummaryLables.get(0).getText();
    }

}
