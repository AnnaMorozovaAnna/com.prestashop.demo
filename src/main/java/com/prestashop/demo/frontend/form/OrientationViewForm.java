package com.prestashop.demo.frontend.form;

import com.codeborne.selenide.SelenideElement;
import com.prestashop.demo.data.BrowserProperty;
import com.prestashop.demo.frontend.Form;
import lombok.experimental.UtilityClass;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class OrientationViewForm extends Form {

    @Override
    public boolean isExist() {
        return OrientationViewElements.SHOP_LOGO
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).isDisplayed();
    }

    @Override
    public String getName() {
        return "Orientation View Form";
    }

    @Override
    public void initContent() {
        switchTo().defaultContent();
    }

    public void hide() {
        OrientationViewElements.HIDE_BUTTON
                .should(enabled, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).click();
    }

    @UtilityClass
    private class OrientationViewElements {
        private final SelenideElement HIDE_BUTTON = $x("//span[text()='Hide']");
        private final SelenideElement SHOP_LOGO = $x("//img[contains(@alt,'PrestaShop logo')]");
    }
}
