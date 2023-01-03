package com.prestashop.cart.conditions;

import com.prestashop.demo.data.CartData;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProceedToCheckoutTestCondition {

    private static final Integer INIT_CART_PRODUCTS_COUNT = 0;
    private static final Integer NEW_CART_PRODUCTS_COUNT = 1;

    @Getter
    private CartData initCartData;
    @Getter
    private CartData newCartData;

    public void prepare() {
        initCartData = new CartData();
        initCartData.setCartProductsCount(INIT_CART_PRODUCTS_COUNT);
        newCartData = new CartData();
        newCartData.setCartProductsCount(NEW_CART_PRODUCTS_COUNT);
    }
}
