package com.epam.mentoring.webdriver;

public enum BrowserType {
    CHROME("chrome"), FIREFOX("firefox");

    private String type;

    BrowserType(String type) {
        this.type = type;
    }
}
