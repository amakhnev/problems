package com.amakhnev.problems.interviewbit.bitmanipulation;

import java.util.Arrays;
import java.util.List;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println("Result = " + new SingleNumber().singleNumber(Arrays.asList(1, 2, 2, 3, 1)));
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int result = 0;
        for (int num : A) {
            result ^= num;
        }
        return result;
    }
}
