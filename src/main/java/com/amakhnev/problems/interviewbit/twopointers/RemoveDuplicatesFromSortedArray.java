package com.amakhnev.problems.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println("Result = " + new RemoveDuplicatesFromSortedArray().removeDuplicates(
                new ArrayList<>(Arrays.asList(1,1,1,2,2,3,3,3,4,4,5,5,6,7,7,7))
        ));
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() < 2) {
            return a.size();
        }

        int i = 0, j = 0, num;
        while (j < a.size()) {
            if (!a.get(j).equals(a.get(i))) { // swap elements in place as .remove has O(n) complexity.
                i++;
                if (j - i != 0) {
                    num = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, num);
                }
            }
            j++;
        }
        return i + 1; // i is the last index of array with no duplicates.


    }

}
