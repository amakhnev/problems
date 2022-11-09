package com.amakhnev.problems.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementFromArray {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(4, 1, 1, 2, 1, 3));

        System.out.println("Result = " + new RemoveElementFromArray().removeElement(a, 1));


    }


    public int removeElement(ArrayList<Integer> a, int b) {
        int i = 0, num;
        for (int j = 0; j < a.size(); j++) {
            num = a.get(j);
            if ((num - b) != 0) {
                a.set(i++, num);
            }
        }
        return i;
    }
}
