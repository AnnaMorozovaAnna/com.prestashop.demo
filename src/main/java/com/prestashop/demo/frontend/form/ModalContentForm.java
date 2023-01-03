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

public class ModalContentForm extends Form {
    @Override
    public boolean isExist() {
        return ModalContentElements.MODAL_LABEL
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).exists();
    }

    @Override
    public String getName() {
        return "Modal Content Form";
    }

    @Override
    public void initContent() {
        switchTo().frame("framelive");
    }

    public boolean isSuccessMessageExist() {
        return ModalContentElements.MODAL_LABEL_SUCCESSFULLY
                .should(appear, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).isDisplayed();
    }

    public void close() {
        ModalContentElements.CLOSE_ICON
                .should(enabled, Duration.ofMillis(BrowserProperty.WAIT_TIMEOUT_MILLISECONDS)).click();
    }

    @UtilityClass
    private class ModalContentElements {
        private final SelenideElement MODAL_LABEL = $x("//h4[@id='myModalLabel']");
        private final SelenideElement CLOSE_ICON = $x("//*[@class='material-icons'][text()='close']");
        private final SelenideElement MODAL_LABEL_SUCCESSFULLY =
                $x("//h4[@id='myModalLabel'][contains(text(),'Product successfully added to your shopping cart')]");
    }
}
