package com.epam.jmp.webdriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactoryManager {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebDriverFactoryManager.class);
    private String chromeBinary;

    public void setChromeBinary(String chromeBinary) {
        this.chromeBinary = chromeBinary;
    }

    private static ThreadLocal<Map<BrowserType, WebDriverFactory>> wdFactoryCache = new InheritableThreadLocal<Map<BrowserType, WebDriverFactory>>() {
        @Override
        protected Map<BrowserType, WebDriverFactory> initialValue() {
            return new HashMap<>();
        }
    };

    public final WebDriverFactory createWebDriverFactory(BrowserType browserType) {
        Map<BrowserType, WebDriverFactory> wdCacheForThread = wdFactoryCache.get();
        WebDriverFactory result;

        if (wdCacheForThread.containsKey(browserType)) {
            result = wdCacheForThread.get(browserType);
            LOGGER.info("The '{}' browser is returned from Cache", result.getClass().getSimpleName());
        } else {
            switch (browserType) {
                case FIREFOX:
                    result = new FirefoxWebDriverFactory();
                    break;
                case CHROME:
                    if (chromeBinary == null) {
                        throw new RuntimeException("Chrome binary isn't set");
                    }
                    result = new ChromeWebDriverFactory(chromeBinary);
                    break;
                default:
                    throw new RuntimeException(browserType.name() + " doesn't have a WebDriverFactory");
            }
        }
        wdCacheForThread.put(browserType, result);
        return result;
    }

}
