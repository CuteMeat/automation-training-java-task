package com.task.automation.fundmentals.optional;

import static com.task.automation.fundmentals.optional.FindLength.findLength;

public class FindLongestElementInArray implements FindInArrayInterface {
    @Override
    public  void find(int[] array){

        int lengthOfElem;

        int longestLength = findLength(array[0]);

        int longestElem = array[0];

        Boolean repeatCheck = true;

        for (int i = 1; i < array.length; i++) {
            lengthOfElem = findLength(array[i]);
            if (lengthOfElem >= longestLength){
                if(lengthOfElem==longestLength) {
                    repeatCheck = false;
                } else {
                    repeatCheck = true;
                    longestLength = lengthOfElem;
                    longestElem = array[i];
                }
            }
        }

        if (repeatCheck) {
            System.out.printf("\nLongest element: %d(length: %d)", longestElem, longestLength);
        } else {
            System.out.printf("\nIn this array there isn't element with a maximum length");
        }
    }
}
