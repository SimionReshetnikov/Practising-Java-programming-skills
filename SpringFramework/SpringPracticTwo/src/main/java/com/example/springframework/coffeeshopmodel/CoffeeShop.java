package com.example.springframework.coffeeshopmodel;

import com.example.springframework.coffeemodel.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("coffeeShop")
public class CoffeeShop {
    private Coffee espresso;
    private Coffee latte;
    private Coffee defaultCoffee;

    @Autowired
    public CoffeeShop(@Qualifier("espresso") Coffee espresso,
                      @Qualifier("latte") Coffee latte,
                      Coffee defaultCoffee) {
        this.espresso = espresso;
        this.latte = latte;
        this.defaultCoffee = defaultCoffee;
    }

    public void orderEspresso() {
        System.out.println(espresso.getDescription());
    }

    public void orderLatte() {
        System.out.println(latte.getDescription());
    }

    public void orderDefaultCoffee() {
        System.out.println(defaultCoffee.getDescription());
    }
}
