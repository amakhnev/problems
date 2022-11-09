package com.amakhnev.problems.interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

public class FindDuplicateInArray {

    public static void main(String[] args) {
        System.out.println("Result = "+ new FindDuplicateInArray().repeatedNumber(Arrays.asList(1,2,3,4,5,6,7,4)));
    }


    public int repeatedNumber(final List<Integer> a) {

        byte[] result = new byte[a.size()];

        for (int value:a){
            result[value]++;
            if (result[value]>1){
                return value;
            }
        }
        return -1;
    }

}
