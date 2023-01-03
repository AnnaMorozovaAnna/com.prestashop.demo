package com.prestashop.demo.driver;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import static com.prestashop.demo.data.BrowserProperty.*;

@Component
public class DriverConfig {

    public void updateSelenideConfiguration(String url) {
        Configuration.startMaximized = START_MAXIMIZED;
        Configuration.browser = BROWSER;
        Configuration.browserVersion = BROWSER_VERSION;
        Configuration.timeout = WAIT_TIMEOUT_MILLISECONDS;
        Configuration.screenshots = SCREENSHOTS;
        Configuration.savePageSource = SAVE_PAGE_SOURCE;
        Configuration.headless = HEADLESS;
        Configuration.pageLoadStrategy = PAGE_LOAD_STRATEGY;
        if (DRIVER_REMOTE) {
            Configuration.remote = url;
            Configuration.driverManagerEnabled = false;
        }
        var browserDesiredCapabilities = DriverConfigFactory.getInstance(BROWSER).getBrowserCapabilities();
        Configuration.browserCapabilities = getCommonDesiredCapabilities().merge(browserDesiredCapabilities);
    }

    private DesiredCapabilities getCommonDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BROWSER);
        capabilities.setVersion(BROWSER_VERSION);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        if (DRIVER_REMOTE) {
            capabilities.setCapability("enableVNC", true);
        }
        return capabilities;
    }
}
