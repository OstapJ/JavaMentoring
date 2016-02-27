package com.epam.jmp.webdriver;

public enum BrowserType {
    CHROME("chrome"), FIREFOX("firefox");

    private String type;

    BrowserType(String type) {
        this.type = type;
    }
}
