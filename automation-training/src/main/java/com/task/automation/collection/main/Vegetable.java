package com.task.automation.collection.main;

public class Vegetable {
    private String name;
    private double calorie;


    public Vegetable(String name, double calorie) {
        this.name = name;
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public double getCalorie() {
        return calorie;
    }

    @Override
    public String toString() {
        return  name + '\t' + calorie;
    }
}

