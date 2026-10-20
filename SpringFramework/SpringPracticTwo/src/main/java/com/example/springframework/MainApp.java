package com.example.springframework;

import com.example.springframework.coffeemodel.Espresso;
import com.example.springframework.coffeemodel.Latte;
import com.example.springframework.coffeeshopmodel.CoffeeShop;
import com.example.springframework.config.CoffeeConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            CoffeeShop shop = context.getBean("coffeeShop", CoffeeShop.class);
            shop.orderEspresso();
            shop.orderLatte();
            CoffeeConfig coffeeConfig = context.getBean("coffeeConfig", CoffeeConfig.class);
            Latte latte1 = coffeeConfig.createLatte();
            Latte latte2 = coffeeConfig.createLatte();
            System.out.println(latte1 == latte2);
            Espresso espresso1 = coffeeConfig.createEspresso();
            Espresso espresso2 = coffeeConfig.createEspresso();
            System.out.println(espresso1 == espresso2);
            shop.orderDefaultCoffee();
        }
    }
}
