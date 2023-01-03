package com.prestashop.demo.frontend.form;

import com.codeborne.selenide.SelenideElement;
import com.prestashop.demo.data.BrowserProperty;
import com.prestashop.demo.data.ProductData;
import com.prestashop.demo.frontend.Form;
import com.prestashop.demo.report.TafLogger;
import lombok.experimental.UtilityClass;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class PopularProductsForm extends Form {

    @Override
    public boolean isExist() {
        return PopularProductsElements.POPULAR_PRODUCTS_HEADER
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).isDisplayed();
    }

    @Override
    public String getName() {
        return "Popular Products Form";
    }

    @Override
    public void initContent() {
        switchTo().frame("framelive");
    }

    public ProductData getFirstProduct() {
        return getProduct("1");
    }

    public ProductData getProduct(String index) {
        ProductData productData = new ProductData();
        String productTitle = PopularProductsElements.getProductTitle(index)
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).getText();
        productData.setTitle(productTitle);
        String regularPrice = PopularProductsElements.getProductRegularPrice(index)
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).getText();
        productData.setRegularPrice(regularPrice);
        String discountPrice = PopularProductsElements.getProductDiscountPrice(index)
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).getText();
        productData.setDiscountPrice(discountPrice);
        TafLogger.info("Product data by {} index selected: {}", index, productData);
        return productData;
    }

    public ProductInfoForm selectFirstProduct() {
        return selectProduct("1");
    }

    public ProductInfoForm selectProduct(String index) {
        PopularProductsElements.getProductImage(index)
                .should(enabled, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).click();
        return new ProductInfoForm();
    }

    @UtilityClass
    private class PopularProductsElements {

        private final SelenideElement POPULAR_PRODUCTS_HEADER = $x("//h2[contains(text(),'Products')]");
        private final SelenideElement FIRST_PRODUCT_IMAGE = $x("//*[contains(@class,'product')][1]//img");

        public SelenideElement getProductImage(String index) {
            String xPath = "//*[contains(@class,'product')][%s]//img";
            return $x(String.format(xPath, index));
        }

        public SelenideElement getProductTitle(String index) {
            String xPath = "//*[contains(@class,'product')][%s]//h3[contains(@class,'product-title')]/a";
            return $x(String.format(xPath, index));
        }

        public SelenideElement getProductRegularPrice(String index) {
            String xPath = "//*[contains(@class,'product')][%s]//*[contains(@class,'regular-price')]";
            return $x(String.format(xPath, index));
        }

        public SelenideElement getProductDiscountPrice(String index) {
            String xPath = "//*[contains(@class,'product')][%s]//*[@class='price']";
            return $x(String.format(xPath, index));
        }
    }
}
