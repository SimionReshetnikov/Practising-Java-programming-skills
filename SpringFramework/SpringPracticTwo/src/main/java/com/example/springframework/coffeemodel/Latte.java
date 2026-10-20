package com.example.springframework.coffeemodel;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Latte implements Coffee {
    private final String name;
    private final double price;

    public Latte() {
        this.name = "Latte";
        this.price = 250.00;
    }

    @PostConstruct
    public void init() {
        System.out.println("Latte создан.");
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
        System.out.println("Latte уничтожен.");
    }
}
