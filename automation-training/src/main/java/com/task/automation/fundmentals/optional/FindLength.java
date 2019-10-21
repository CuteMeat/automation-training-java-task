package com.task.automation.fundmentals.optional;

public class FindLength {

    public static int findLength(int element) {

        int lengthOfElement = 0;

        do {
            element/=10;
            ++lengthOfElement;
        } while(element!=0);

        return lengthOfElement;

    }
}
