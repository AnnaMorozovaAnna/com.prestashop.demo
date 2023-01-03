package com.prestashop.demo.frontend.config;

import com.prestashop.demo.frontend.form.CartFom;
import com.prestashop.demo.frontend.form.PopularProductsForm;
import com.prestashop.demo.frontend.page.StoreDemoPage;
import org.springframework.context.annotation.Bean;

public class PageConfiguration {

    @Bean
    public StoreDemoPage storeDemoPage(PopularProductsForm popularProductsForm) {
        return new StoreDemoPage(popularProductsForm);
    }

    @Bean
    public CartFom cartPage() {
        return new CartFom();
    }
}