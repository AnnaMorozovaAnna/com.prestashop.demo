package com.prestashop.cart.conditions;

import com.prestashop.demo.data.CartData;
import com.prestashop.demo.report.TafLogger;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddOneProductToCartTestCondition {

    private static final Integer INIT_CART_PRODUCTS_COUNT = 0;
    private static final Integer NEW_CART_PRODUCTS_COUNT = 1;
    private final String fooMessage;
    @Getter
    private CartData initCartData;
    @Getter
    private CartData newCartData;

    public void prepare() {
        TafLogger.info(fooMessage);
        initCartData = new CartData();
        initCartData.setCartProductsCount(INIT_CART_PRODUCTS_COUNT);
        newCartData = new CartData();
        newCartData.setCartProductsCount(NEW_CART_PRODUCTS_COUNT);
    }
}
