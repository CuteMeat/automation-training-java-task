package com.task.automation.collection.main;

import java.util.Scanner;

public class Menu {

    private Scanner in = new Scanner(System.in);
    private Salad salad = new Salad();

    public void mainMenu() {
        int check = -1;
        Boolean exitCheck = true;
        while (exitCheck) {
            System.out.println("1. Create salad");
            System.out.println("2. View salad");
            System.out.println("0. Exit program;");
            check = in.nextInt();
            switch (check) {
                case 1:
                    createSalad();
                    break;
                case 2:
                    saladView();
                    break;
                case 0:
                    exitCheck = false;
                    break;
                default:
            }
        }
    }

    public void createSalad() {
        int check = -1;

        Boolean exitCheck = true;

        while (exitCheck) {
            System.out.println("1. Add vegetable;");
            System.out.println("2. Remove vegetable;");
            System.out.println("3. Save salad.");
            check = in.nextInt();
            switch (check) {
                case 1:
                    addingVegetables();
                    break;
                case 2:
                    removeVegetable();
                    break;
                case 3:
                    exitCheck = false;
                    break;
                default:
            }
        }
    }

    public void saladView() {
        for (Vegetable vegetable:salad.getVegetables()) {
            System.out.println(vegetable.getName() + ":\t"+vegetable.getCalorie());
        }

        int check = -1;
        Boolean exitCheck = true;

        while (exitCheck) {
            System.out.println("1. Sort by name;");
            System.out.println("2. Sort by calories;");
            System.out.println("3. Find vegetables with selected calorie;");
            System.out.println("0. Exit;");
            check = in.nextInt();
            switch (check) {
                case 1:
                    salad.sortByName();
                    System.out.println(salad);
                    break;
                case 2:
                    salad.sortByCalories();
                    System.out.println(salad);
                    break;
                case 3:
                    System.out.println("Input min:");
                    int min = in.nextInt();
                    System.out.println("Input max:");
                    int max = in.nextInt();
                    salad.findingVegetablesWithCalorieAroundSelected(min, max);
                    break;
                case 0:
                    exitCheck = false;
                    break;
                default:
            }
        }
    }

    public void addingVegetables() {
        int maxAmount = 7;
        Boolean exitCheck = true;
        while (exitCheck && (salad.getVegetables().size()<maxAmount)) {
            System.out.println("1. TomatoAvocado;");
            System.out.println("2. Cucumber;");
            System.out.println("3. Beet;");
            System.out.println("4. Spinach;");
            System.out.println("5. Avocado;");
            System.out.println("6. Zucchini;");
            System.out.println("Select vegetable or enter 0 for exit:");
            int check = in.nextInt();
            switch (check) {
                case 1:
                    Vegetable tomato = new Vegetable("Tomato", 20);
                    salad.addVegetable(tomato);
                    break;
                case 2:
                    Vegetable cucumber = new Vegetable("Cucumber", 13.5);
                    salad.addVegetable(cucumber);
                    break;
                case 3:
                    Vegetable beet = new Vegetable("Beet", 43);
                    salad.addVegetable(beet);
                    break;
                case 4:
                    Vegetable spinach = new Vegetable("Spinach", 16);
                    salad.addVegetable(spinach);
                    break;
                case 5:
                    Vegetable avocado = new Vegetable("Avocado", 160);
                    salad.addVegetable(avocado);
                    break;
                case 6:
                    Vegetable zucchini = new Vegetable("Zucchini", 13.5);
                    salad.addVegetable(zucchini);
                    break;
                case 0:
                    exitCheck = false;
                    break;
                default:
                    System.out.println("Error.");
            }
        }
    }

    public void removeVegetable() {

        Boolean exitCheck = true;
        int minAmount = 0;

        while (exitCheck && (salad.getVegetables().size()>minAmount)) {
            for (int i = 0; i < salad.getVegetables().size(); i++) {
                System.out.println((i+1)+". "+salad.getVegetables().get(i).getName());
            }
            int check = in.nextInt();
            switch (check) {
                case 1:
                    salad.removeVegetable(0);
                    break;
                case 2:
                    salad.removeVegetable(1);
                    break;
                case 3:
                    salad.removeVegetable(2);
                    break;
                case 4:
                    salad.removeVegetable(3);
                    break;
                case 5:
                    salad.removeVegetable(4);
                    break;
                case 6:
                    salad.removeVegetable(5);
                    break;
                case 0:
                    exitCheck = false;
                    break;
                default:
                    System.out.println("Error.");
            }
        }
    }
}
