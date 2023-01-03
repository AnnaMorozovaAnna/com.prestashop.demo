package com.prestashop.demo.util;

import com.prestashop.demo.report.TafLogger;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class PropertiesReader {

    /**
     * Load properties
     *
     * @param path path to property
     * @return {@link Properties}
     */
    public Properties loadProperties(String path) {
        Properties result = new Properties();
        try (InputStream inputStream = PropertiesReader.class.getResourceAsStream(path)) {
            result.load(inputStream);
        } catch (IOException e) {
            TafLogger.fail("Couldn't load properties from resource with path: {}. Error: {}",
                    path, e.getMessage());
        }
        return result;
    }
}
