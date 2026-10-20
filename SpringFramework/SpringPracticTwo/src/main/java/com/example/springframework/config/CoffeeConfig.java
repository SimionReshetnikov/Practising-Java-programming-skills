package com.example.springframework.config;

import com.example.springframework.coffeemodel.Espresso;
import com.example.springframework.coffeemodel.Latte;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class CoffeeConfig {
    @Bean("espresso")
    @Primary
    public Espresso createEspresso() {
        return new Espresso();
    }

    @Bean("latte")
    @Scope("prototype")
    public Latte createLatte() {
        return new Latte();
    }
}
