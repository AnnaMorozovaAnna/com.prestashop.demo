package com.prestashop.demo.util;

import com.prestashop.demo.exeption.PrestaShopException;
import lombok.experimental.UtilityClass;

import java.time.Duration;

@UtilityClass
public class Waiter {

    public void makeDelay(Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        } catch (Exception e) {
            throw new PrestaShopException("Delay duration interrupted with error!", e.getCause());
        }
    }
}