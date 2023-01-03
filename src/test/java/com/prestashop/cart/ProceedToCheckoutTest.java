package com.prestashop.cart;

import com.prestashop.BaseTest;
import com.prestashop.cart.conditions.ProceedToCheckoutTestCondition;
import com.prestashop.demo.frontend.form.OrientationViewForm;
import com.prestashop.demo.frontend.page.StoreDemoPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("Cart: proceed to checkout from cart")
public class ProceedToCheckoutTest extends BaseTest {

    @Autowired
    private ProceedToCheckoutTestCondition proceedToCheckoutTestCondition;
    @Autowired
    private OrientationViewForm orientationViewForm;
    @Autowired
    private StoreDemoPage storeDemoPage;

    @Test
    @Tags({
            @Tag("level:smoke"),
            @Tag("level:regression"),
            @Tag("feature:cart"),
            @Tag("case-id:004")
    })
    void proceedToCheckoutFromCart() {
        proceedToCheckoutTestCondition.prepare();

        orientationViewForm.initContent();
        orientationViewForm.assertIsExist();
        orientationViewForm.hide();

        storeDemoPage.initContent();
        storeDemoPage.assertIsExist();
        var cartProductsCount = storeDemoPage.getCartProductsCount();
        Assertions.assertThat(cartProductsCount)
                .as("Check initial cart products count!")
                .isEqualTo(proceedToCheckoutTestCondition.getInitCartData().getCartProductsCount());

        var popularProductsForm = storeDemoPage.getPopularProductsForm();
        popularProductsForm.assertIsExist();
        var expProductData = popularProductsForm.getFirstProduct();
        var expTitle = expProductData.getTitle().toUpperCase();
        expProductData.setTitle(expTitle);
        var productInfoForm = popularProductsForm.selectFirstProduct();
        productInfoForm.assertIsExist();
        var actProductData = productInfoForm.getProductData();
        Assertions.assertThat(actProductData)
                .as("Check selected product data!")
                .isEqualTo(expProductData);

        var modalContentForm = productInfoForm.addToCart();
        modalContentForm.assertIsExist();
        var isProductAdded = modalContentForm.isSuccessMessageExist();
        Assertions.assertThat(isProductAdded)
                .as("Check product was added to cart!")
                .isTrue();

        modalContentForm.close();
        cartProductsCount = storeDemoPage.getCartProductsCount();
        Assertions.assertThat(cartProductsCount)
                .as("Check updated cart products count!")
                .isEqualTo(proceedToCheckoutTestCondition.getNewCartData().getCartProductsCount());

        var cartForm = storeDemoPage.openCart();
        cartForm.assertIsExist();
        Assertions.assertThat(cartForm.isProceedToCheckoutButtonEnabled())
                .as("Check proceed to checkout button!")
                .isTrue();
    }
}
