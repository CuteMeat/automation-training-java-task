package com.task.automation.javaclass.main;

import java.util.Calendar;

public class ListOfCars {
    private Car[] cars;
    public ListOfCars() {
        cars = new Car[0];
    }

    public void addCar(Car newCar) {
        Car[] newCars = new Car[cars.length+1];
        for (int i = 0; i < newCars.length-1; i++) {
            newCars[i]=cars[i];
        }
        newCars[newCars.length-1] = newCar;
        cars = newCars;
    }

    public void removeCar(Car car) {
        Car[] tmpCars = new Car[cars.length-1];
        if(cars.length!=0) {
            for (int i = 0, tmpCounter=0; i < cars.length; i++) {
                if(cars[i].getId()!=car.getId()) {
                    tmpCars[tmpCounter]=cars[i];
                    tmpCounter++;
                }
            }
            cars = tmpCars;
        } else {
            System.out.println("The list of cars is empty.");
        }
    }

    /**
     * Вывод списка автомобилей с выбранной маркой.
     * @param brand
     */

    public void showCarOfTheSelectedBrand(String brand) {
        for (Car car: cars) {
            if(car.getBrand()==brand) {
                System.out.println(car.toString());
            }
        }
    }

    /**список автомобилей заданной модели, которые эксплуатируются больше n лет.
     *
     * @param brand
     * @param year
     */

    public void showCarOfTheSelectedBrandAndOperationTimeIsLongerThen(String brand, int year) {
        for (Car car: cars) {
            if((car.getBrand()==brand)&&((Calendar.getInstance().get(Calendar.YEAR)-car.getYear())>year)) {
                System.out.println(car.toString());
            }
        }
    }

    /**список автомобилей заданного года выпуска, цена которых больше указанной.
     *
     * @param year
     * @param price
     */
    public  void showCarOfTheSelectedYearAndMoreSelectedPrice(int year, int price) {
        for (Car car: cars) {
            if((car.getYear()==year)&&(car.getPrice()>price)) {
                System.out.println(car.toString());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Car car: cars) {
            str.append("\t\t").append(car.getId());
            str.append("\t\t").append(car.getBrand()).append("\t\t").append(car.getModel());
            str.append("\t\t").append(car.getYear()).append("\t\t").append(car.getColor()).append("\t\t");
            str.append(car.getPrice()).append("\t\t").append(car.getRegistrationNumber()).append("\t\n");
        }
        return str.toString();
    }
}
