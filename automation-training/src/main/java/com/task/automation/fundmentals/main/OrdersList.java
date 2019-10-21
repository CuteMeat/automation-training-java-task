package com.task.automation.fundmentals.main;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrdersList {
    private int orderNumber;
    private int customerNumber;
    private Pizza[] pizzaList;

    public OrdersList() {

        this.orderNumber=(int) ( Math.random() * (100000-10000) + 10000);
        this.customerNumber = (int) ( Math.random() * (100000-10000) + 10000);
        pizzaList = new Pizza[0];

    }

    public void addPizza(Pizza newPizza) {

        Pizza[] pizza = new Pizza[pizzaList.length+1];

        if(Arrays.stream(pizzaList).noneMatch(obj->Objects.equals(obj.getName(), newPizza.getName()))) {
            for (int i = 0; i < pizza.length-1; i++) {
                pizza[i] = pizzaList[i];
            }
            pizza[pizza.length-1] = newPizza;
            pizzaList = pizza;
        }

    }

    public double getTotal() {

        return  Arrays.stream(pizzaList)
                .collect(Collectors.summingDouble(obj->obj.getAmount()*obj.getPrice()));

    }

    public String toString() {

        StringBuilder outPut = new StringBuilder();
        outPut.append("\t*******************************************\n");
        outPut.append("\tOrder:\t\t\t\t\t\t\t\t").append(orderNumber).append("\n\tCustomer:\t\t\t\t\t\t\t");
        outPut.append(customerNumber);

        for (Pizza pizza:pizzaList) {
            outPut.append("\n\t-------------------------------------------");
            outPut.append("\n\tPizza name:\t\t\t\t\t").append(pizza.getName());
            outPut.append("\n\tPizza type:\t\t\t\t\t").append(pizza.getType());

            for (Ingredient ingredient:pizza.getIngredients()) {
                outPut.append("\n\t\t").append(ingredient.getName()).append("\n\t\t\t\t\t\t\t\t\t\t");
                outPut.append(ingredient.getPrice());
            }

            outPut.append("\n\t___________________________________________\n");
            outPut.append("\tPrice:\t\t\t").append(pizza.getPrice());
            outPut.append("\t\tAmount:\t\t\t").append(pizza.getAmount());
            outPut.append("\n\t-------------------------------------------\n");
        }
        outPut.append("\t\t==\tTOTAL PRICE:\t").append(getTotal()).append("\t==");

        return outPut.toString();

    }
}
