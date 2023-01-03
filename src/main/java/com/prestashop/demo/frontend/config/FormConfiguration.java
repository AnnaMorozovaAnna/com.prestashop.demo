package com.prestashop.demo.frontend.config;

import com.prestashop.demo.frontend.form.OrientationViewForm;
import com.prestashop.demo.frontend.form.PopularProductsForm;
import com.prestashop.demo.frontend.form.ProductInfoForm;
import org.springframework.context.annotation.Bean;

public class FormConfiguration {

    @Bean
    public OrientationViewForm OrientationViewForm() {
        return new OrientationViewForm();
    }

    @Bean
    public PopularProductsForm popularProductsForm() {
        return new PopularProductsForm();
    }

    @Bean
    public ProductInfoForm productInfoForm() {
        return new ProductInfoForm();
    }
}
