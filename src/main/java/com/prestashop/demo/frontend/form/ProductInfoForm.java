package com.prestashop.demo.frontend.form;

import com.codeborne.selenide.SelenideElement;
import com.prestashop.demo.data.BrowserProperty;
import com.prestashop.demo.data.ProductData;
import com.prestashop.demo.frontend.Form;
import com.prestashop.demo.report.TafLogger;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

@NoArgsConstructor
public class ProductInfoForm extends Form {

    @Override
    public boolean isExist() {
        return ProductInfoElements.PRODUCT_DETAILS
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).isDisplayed();
    }

    @Override
    public String getName() {
        return "Product Info Form";
    }

    @Override
    public void initContent() {
        switchTo().frame("framelive");
    }

    public ProductData getProductData() {
        ProductData productData = new ProductData();
        String productTitle = ProductInfoElements.PRODUCT_TITLE
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).getText();
        productData.setTitle(productTitle);
        String regularPrice = ProductInfoElements.PRODUCT_REGULAR_PRICE
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).getText();
        productData.setRegularPrice(regularPrice);
        String discountPrice = ProductInfoElements.PRODUCT_DISCOUNT_PRICE
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).getText();
        productData.setDiscountPrice(discountPrice);
        TafLogger.info("Product data info: {}", productData);
        return productData;
    }

    public ModalContentForm addToCart() {
        ProductInfoElements.ADD_TO_CART_BUTTON
                .should(enabled, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).click();
        return new ModalContentForm();
    }

    @UtilityClass
    private class ProductInfoElements {
        private final SelenideElement PRODUCT_DETAILS = $x("//*[@aria-controls='product-details']");
        private final SelenideElement PRODUCT_TITLE = $x("//h1[contains(@class,'h1')]");
        private final SelenideElement PRODUCT_REGULAR_PRICE = $x("//*[contains(@class,'regular-price')]");
        private final SelenideElement PRODUCT_DISCOUNT_PRICE = $x("//*[@class='current-price-value']");
        private final SelenideElement ADD_TO_CART_BUTTON = $x("//button[@data-button-action='add-to-cart']");
    }
}
