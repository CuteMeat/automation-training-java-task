package com.task.automation.collection.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class Salad {

    private ArrayList<Vegetable> vegetables;

    public Salad () {
        vegetables = new ArrayList<Vegetable>();
    }

    public ArrayList<Vegetable> getVegetables() {return vegetables;}

    public void addVegetable(Vegetable newVegetable) {

        if(vegetables.stream().noneMatch(obj -> Objects.equals(obj.getName(), newVegetable.getName()))) {
            vegetables.add(newVegetable);
        } else {
            System.out.printf("The %s was added earlier\n", newVegetable.getName());
        }

    }

    public void removeVegetable(int indexOfVegetable) {
        vegetables.remove(indexOfVegetable);
    }

    public double totalCalorie() {

        return vegetables.stream().collect(Collectors.summingDouble(obj->obj.getCalorie()));
    }

    public void sortByName() {
        Comparator<Vegetable> comparator = Comparator.comparing(obj -> obj.getName());
        Collections.sort(vegetables, comparator);
    }

    public void sortByCalories() {
        Comparator<Vegetable> comparator = Comparator.comparing(obj -> obj.getCalorie());
        Collections.sort(vegetables, comparator);
    }

    public void findingVegetablesWithCalorieAroundSelected(int minCalorie, int maxCalorie) {

        vegetables.stream().filter(obj -> (obj.getCalorie()>=minCalorie) && (obj.getCalorie()<=maxCalorie))
                .forEach(System.out::println);

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\t\t\t\t==").append("==\t\t\n");
        for (Vegetable vegetable:vegetables) {
            result.append("\t\t").append(vegetable.getName()).append(": ").append(vegetable.getCalorie()).append("\n");
        }
        result.append("\t\t\tTOTAL CALORIES: ").append(totalCalorie());

        return result.toString();
    }
}
