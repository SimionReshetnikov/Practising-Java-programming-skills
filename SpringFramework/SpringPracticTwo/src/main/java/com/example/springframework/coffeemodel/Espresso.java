package com.example.springframework.coffeemodel;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Espresso implements Coffee {
    private final String name;
    private final Double price;

    public Espresso() {
        this.name = "Espresso";
        this.price = 150.00;
    }

    @PostConstruct
    public void init() {
        System.out.println("Espresso создан");
    }

    @Override
    public String getDescription() {
        return String.format("Описание:\nНазвание - %s;\nСтоимость:%.2f.",
                name, price);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Espresso уничтожен.");
    }
}
