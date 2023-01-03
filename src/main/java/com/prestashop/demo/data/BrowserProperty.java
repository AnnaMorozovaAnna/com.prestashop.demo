package com.prestashop.demo.data;

import com.prestashop.demo.util.PropertiesReader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrowserProperty {

    public static final String BROWSER;
    public static final String BROWSER_VERSION;
    public static final long WAIT_TIMEOUT_MILLISECONDS;
    public static final boolean START_MAXIMIZED;
    public static final boolean DRIVER_REMOTE;
    public static final boolean SCREENSHOTS;
    public static final boolean SAVE_PAGE_SOURCE;
    public static final boolean HEADLESS;
    public static final String PAGE_LOAD_STRATEGY;
    public static final String DOCKER_HOST;
    public static final int DOCKER_PORT;
    public static final String DOCKER_PATH;

    static {
        Properties properties = PropertiesReader.loadProperties("/docker/browser.properties");
        BROWSER = properties.getProperty(
                "browser"
        );
        BROWSER_VERSION = properties.getProperty(
                "browser.version"
        );
        WAIT_TIMEOUT_MILLISECONDS = Long.parseLong(properties.getProperty(
                "wait.timeout.milliseconds"
        ));
        START_MAXIMIZED = Boolean.parseBoolean(properties.getProperty(
                "startMaximized"
        ));
        DRIVER_REMOTE = Boolean.parseBoolean(properties.getProperty(
                "driver.remote"
        ));
        SCREENSHOTS = Boolean.parseBoolean(properties.getProperty(
                "screenshots"
        ));
        SAVE_PAGE_SOURCE = Boolean.parseBoolean(properties.getProperty(
                "savePageSource"
        ));
        HEADLESS = Boolean.parseBoolean(properties.getProperty(
                "headless"
        ));
        PAGE_LOAD_STRATEGY = properties.getProperty(
                "pageLoadStrategy"
        );
        DOCKER_HOST = properties.getProperty(
                "docker.host"
        );
        DOCKER_PORT = Integer.parseInt(properties.getProperty(
                "docker.port"
        ));
        DOCKER_PATH = properties.getProperty(
                "docker.path"
        );
    }

}
