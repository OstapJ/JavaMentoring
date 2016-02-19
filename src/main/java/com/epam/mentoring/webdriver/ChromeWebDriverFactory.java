package com.epam.mentoring.webdriver;

        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeWebDriverFactory implements WebDriverFactory {

    private String pathToBinary;

    public ChromeWebDriverFactory(String pathToBinary) {
        this.pathToBinary = pathToBinary;
    }

    @Override
    public synchronized ChromeDriver createWebDriver() {
        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        chromeCapabilities.setCapability("binary", pathToBinary);
        return new ChromeDriver(chromeCapabilities);
    }
}
