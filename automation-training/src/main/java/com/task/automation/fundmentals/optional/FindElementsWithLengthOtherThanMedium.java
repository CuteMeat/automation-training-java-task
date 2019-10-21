package com.task.automation.fundmentals.optional;

import static com.task.automation.fundmentals.optional.FindLength.findLength;

public class FindElementsWithLengthOtherThanMedium implements FindInArrayInterface{
    @Override
    public void find(int[] array) {

        int mediumLength = 0;

        int tmpLength;

        for (int element:array) {
            mediumLength+=findLength(element);
        }

        mediumLength/=array.length;

        for (int element:array) {
            tmpLength=findLength(element);
            if(tmpLength!=mediumLength) {
                System.out.printf("\t%d(length: %d)\t", element, tmpLength);
            }
        }
    }
}
