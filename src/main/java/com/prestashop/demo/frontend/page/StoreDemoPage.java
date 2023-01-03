package com.prestashop.demo.frontend.page;

import com.codeborne.selenide.SelenideElement;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.prestashop.demo.data.BrowserProperty;
import com.prestashop.demo.frontend.Page;
import com.prestashop.demo.frontend.form.CartFom;
import com.prestashop.demo.frontend.form.PopularProductsForm;
import com.prestashop.demo.report.TafLogger;
import com.prestashop.demo.util.StringMatcher;
import com.prestashop.demo.util.TextFormatter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

@RequiredArgsConstructor
public class StoreDemoPage extends Page {

    @Getter
    private final PopularProductsForm popularProductsForm;

    @Override
    public void initContent() {
        switchTo().frame("framelive");
    }

    @Override
    public boolean isExist() {
        return StoreDemoElements.MY_STORE_LOGO
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).isDisplayed();
    }

    @Override
    public String getName() {
        return "Store Demo Page";
    }

    public Integer getCartProductsCount() {
        String text = StoreDemoElements.CART_PRODUCTS_COUNT
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).getText();
        TafLogger.info("Cart products count: " + text);
        String regexp = "(\\d+)";
        String count = StringMatcher.getFirstMatch(regexp, text, 1);
        return TextFormatter.formatTextToNumber(count);
    }

    public CartFom openCart() {
        StoreDemoElements.CART_PRODUCTS_COUNT
                .should(enabled, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).click();
        return new CartFom();
    }

    @CanIgnoreReturnValue
    public StoreDemoPage openInitialStoreDemoPage() {
        StoreDemoElements.HOME_LINK
                .should(enabled, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).click();
        return this;
    }

    @UtilityClass
    private class StoreDemoElements {
        private final SelenideElement MY_STORE_LOGO = $x("//h1//img[contains(@class,'logo')]");
        private final SelenideElement HOME_LINK = $x("//img[contains(@class,'logo')]");
        private final SelenideElement CART_PRODUCTS_COUNT = $x("//*[@class='cart-products-count']");
    }
}
