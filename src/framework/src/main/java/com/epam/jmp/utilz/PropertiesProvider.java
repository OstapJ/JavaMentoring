package com.epam.jmp.utilz;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertiesProvider
{
    private static Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        URL props = ClassLoader.getSystemResource("runConfigProperties");

        try {
            PROPERTIES.load(props.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperties(String key) {
        return PROPERTIES.getProperty(key);
    }
}
