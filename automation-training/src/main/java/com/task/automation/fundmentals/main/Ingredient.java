package com.task.automation.fundmentals.main;

public class Ingredient {
    private String name;
    private double price;

    public String getName() {return name;}

    public double getPrice() {
        return price;
    }

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

