package com.prestashop.demo.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TextFormatter {

    public Integer formatTextToNumber(String text) {
        return Integer.valueOf(text);
    }
}
