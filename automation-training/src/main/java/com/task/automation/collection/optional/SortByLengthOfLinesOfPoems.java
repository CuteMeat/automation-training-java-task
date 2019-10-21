package com.task.automation.collection.optional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByLengthOfLinesOfPoems {
    public static void main(String[] args) {
        ArrayList<String> nameOfPoems = new ArrayList<String>();
        nameOfPoems.add("Косой дождь");
        nameOfPoems.add("Абсурдный час");
        nameOfPoems.add("Абажур");
        nameOfPoems.add("Мамин сорванец");
        nameOfPoems.add("Песня");

        Comparator<String> comparator = Comparator.comparing(obj -> obj.length());
        Collections.sort(nameOfPoems, comparator);

        for (String poemsLines: nameOfPoems) {
            System.out.println(poemsLines);
        }
    }
}

