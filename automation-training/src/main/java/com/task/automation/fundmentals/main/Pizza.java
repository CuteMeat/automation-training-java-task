package com.task.automation.fundmentals.main;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pizza {
    private String name;
    private Ingredient[] ingredients;
    private String type;
    private int amount;
    private double price;
    private static final int MAX_AMOUNT_OF_INGREDIENT = 8;

    public String getName() {return name;}
    public String getType() {return type;}
    public Ingredient[] getIngredients() {return ingredients;}
    public int getAmount() {return amount;}
    public double getPrice(){
        if(type=="Base")
            price = 1;
        else
            price = 1.5;
        price += Arrays.stream(ingredients).collect(Collectors.summingDouble(obj -> obj.getPrice()));
        return price;
    }

    public Pizza (String name, String type, int amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.ingredients=new Ingredient[0];
        this.price=0;
    }

    public void addIngredient(Ingredient newIngredient) {

        if(ingredients.length <= MAX_AMOUNT_OF_INGREDIENT) {
            if(Arrays.stream(ingredients)
                    .noneMatch(obj -> Objects.equals(obj.getName(), newIngredient.getName()))) {
                Ingredient[] newIngredients = new Ingredient[ingredients.length+1];
                for (int i = 0; i < newIngredients.length-1; i++) {
                    newIngredients[i] = ingredients[i];
                }
                newIngredients[newIngredients.length-1] = newIngredient;
                ingredients = newIngredients;
            } else {
                System.out.println("In " + this.name + " ingredient " + newIngredient.getName() + " was add early.");
            }
        } else {
            System.out.println("Full pizza.");
        }

    }

    public void changeName(int customerNumber, int pizzaNumber) {
        name = (customerNumber+"_"+pizzaNumber);
    }

    public void removeIngredient(int number){
        if(number>ingredients.length-1 || ingredients.length==0) {
            System.out.println("Error");
        }
        else {
            Ingredient[] newIngredient = new Ingredient[ingredients.length-1];

            for (int i = 0, tmp = 0; i < ingredients.length; i++) {
                if(i!=number) {
                    newIngredient[tmp] = ingredients[i];
                    tmp++;
                }
            }
            ingredients = newIngredient;
        }
    }
}
