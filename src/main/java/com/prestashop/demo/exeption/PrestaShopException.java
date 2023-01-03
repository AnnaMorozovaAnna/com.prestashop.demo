package com.prestashop.demo.exeption;

public class PrestaShopException extends RuntimeException {

    public PrestaShopException(String message) {
        super(message);
    }

    public PrestaShopException(String message, Throwable cause) {
        super(message, cause);
    }
}
