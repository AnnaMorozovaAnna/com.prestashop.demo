package com.prestashop.demo.frontend;

import org.assertj.core.api.Assertions;

public abstract class Page implements Attributes {

    public abstract void initContent();

    public void assertIsExist() {
        boolean res = isExist();
        Assertions.assertThat(res)
                .as("Check that " + getName() + " page exists!")
                .isTrue();
    }
}