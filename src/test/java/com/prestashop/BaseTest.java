package com.prestashop;

import com.prestashop.cart.conditions.config.CartTestConditionConfiguration;
import com.prestashop.demo.driver.DriverConfig;
import com.prestashop.demo.frontend.config.FormConfiguration;
import com.prestashop.demo.frontend.config.PageConfiguration;
import com.prestashop.demo.report.TafLogger;
import com.prestashop.demo.util.Waiter;
import org.awaitility.Durations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codeborne.selenide.Selenide.*;

@SpringBootTest(classes = {
        CartTestConditionConfiguration.class,
        FormConfiguration.class,
        PageConfiguration.class
})
@EnableAutoConfiguration
@EnableConfigurationProperties
public class BaseTest {

    protected DriverConfig driverConfig = new DriverConfig();
    @Value("${web.link:}")
    private String url;

    @BeforeEach()
    protected void setDriverConfig() {
        onTestStart();
        driverConfig.updateSelenideConfiguration(url);
        open(url);
        Waiter.makeDelay(Durations.FIVE_SECONDS);
    }

    @AfterEach()
    public void tearDown() {
        clearBrowserLocalStorage();
        closeWindow();
        onTestFinish();
    }

    private void onTestStart() {
        TafLogger.info("====================================================");
        TafLogger.info("===================== Started =====================");
        TafLogger.info("TEST STARTED : [{}]", this.getClass().getName());
        TafLogger.info("====================================================");
        TafLogger.info("==================┬┴┬┴┤(･_├┬┴┬┴=====================");
        TafLogger.info("====================================================");
    }

    private void onTestFinish() {
        TafLogger.info("====================================================");
        TafLogger.info("TEST FINISHED : [{}]", this.getClass().getName());
        TafLogger.info("===================== Finished =====================");
        TafLogger.info("====================================================");
    }
}
