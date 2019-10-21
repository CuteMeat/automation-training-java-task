package com.task.automation.fundmentals.optional;

import java.util.Scanner;

public class ArrayTaskLaunch {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        FindShortestElementInArray findShortestElementInArray = new FindShortestElementInArray();

        FindLongestElementInArray findLongestElementInArray = new FindLongestElementInArray();

        FindElementsWithLengthOtherThanMedium findElementsWithLengthOtherThanMedium
                = new FindElementsWithLengthOtherThanMedium();

        System.out.print("Enter array dimension: ");

        int size = in.nextInt();

        int[] array = new int[size];

        System.out.println("Enter array elements");
        for (int i = 0; i < size; i++) {
            System.out.printf("Array[%d]:\t", i);
            array[i] = in.nextInt();
        }

        System.out.println("Element with length other than medium: ");

        findElementsWithLengthOtherThanMedium.find(array);

        findLongestElementInArray.find(array);

        findShortestElementInArray.find(array);

    }
}
