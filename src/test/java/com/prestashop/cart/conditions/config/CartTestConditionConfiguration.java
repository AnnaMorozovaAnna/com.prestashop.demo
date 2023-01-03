package com.prestashop.cart.conditions.config;

import com.prestashop.cart.conditions.AddOneProductToCartTestCondition;
import com.prestashop.cart.conditions.AddTwoDifferentProductsToCartTestCondition;
import com.prestashop.cart.conditions.AddTwoIdenticalProductsToCartTestCondition;
import com.prestashop.cart.conditions.ProceedToCheckoutTestCondition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"ui/application.yml"})
public class CartTestConditionConfiguration {

    @Bean
    public AddOneProductToCartTestCondition addOneProductToCartTestCondition(@Value("${foo.message:}") String fooMessage) {
        return new AddOneProductToCartTestCondition(fooMessage);
    }

    @Bean
    public AddTwoIdenticalProductsToCartTestCondition addTwoProductsToCartTestCondition() {
        return new AddTwoIdenticalProductsToCartTestCondition();
    }

    @Bean
    public AddTwoDifferentProductsToCartTestCondition addTwoDifferentProductsToCartTestCondition() {
        return new AddTwoDifferentProductsToCartTestCondition();
    }

    @Bean
    public ProceedToCheckoutTestCondition proceedToCheckoutTestCondition() {
        return new ProceedToCheckoutTestCondition();
    }
}
