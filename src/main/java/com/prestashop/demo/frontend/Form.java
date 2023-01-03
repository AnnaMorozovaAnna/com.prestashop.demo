package com.prestashop.demo.frontend;

import org.assertj.core.api.Assertions;

public abstract class Form implements Attributes {

    public abstract void initContent();

    public void assertIsExist() {
        Assertions.assertThat(isExist())
                .as("Check that " + getName() + " form exists!")
                .isTrue();
    }
}
