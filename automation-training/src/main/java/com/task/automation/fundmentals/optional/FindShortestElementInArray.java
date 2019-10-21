package com.task.automation.fundmentals.optional;

import static com.task.automation.fundmentals.optional.FindLength.findLength;

public class FindShortestElementInArray implements FindInArrayInterface{

    @Override
    public void find(int[] array) {
        int lengthOfElem;

        int shortestLength = findLength(array[0]);

        int shortestElem=array[0];

        Boolean repeatCheck = true;

        for (int i = 1; i < array.length; i++) {
            lengthOfElem = findLength(array[i]);
            if (lengthOfElem <= shortestLength){
                if(lengthOfElem==shortestLength) {
                    repeatCheck = false;
                }
                else {
                    repeatCheck = true;
                }
                shortestLength = lengthOfElem;
                shortestElem = array[i];
            }
        }

        if (repeatCheck) {
            System.out.printf("\nShortest element: %d(length: %d)", shortestElem, shortestLength);
        } else {
            System.out.printf("\nIn this array there isn't element with a minimum length");
        }
    }
}
