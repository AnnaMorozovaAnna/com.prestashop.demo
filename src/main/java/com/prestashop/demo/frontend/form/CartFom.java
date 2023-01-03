package com.prestashop.demo.frontend.form;

import com.codeborne.selenide.SelenideElement;
import com.prestashop.demo.data.BrowserProperty;
import com.prestashop.demo.frontend.Page;
import lombok.experimental.UtilityClass;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class CartFom extends Page {

    @Override
    public boolean isExist() {
        return CartElements.SHOPPING_CART_HEADER
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).isDisplayed();
    }

    @Override
    public String getName() {
        return "Cart Form";
    }

    @Override
    public void initContent() {
        switchTo().frame("framelive");
    }

    public boolean isProceedToCheckoutButtonEnabled() {
        return CartElements.PROCEED_TO_CHECKOUT_BUTTON
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).isEnabled();
    }

    @UtilityClass
    private class CartElements {
        private final SelenideElement SHOPPING_CART_HEADER = $x("//h1[contains(text(),'Shopping Cart')]");
        private final SelenideElement PROCEED_TO_CHECKOUT_BUTTON =
                $x("//*[contains(@class,'btn-primary')][contains(text(),'Proceed to checkout')]");
    }
}
