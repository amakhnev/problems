package com.amakhnev.problems.interviewbit.math;

public class TrailingZerosInFactorial {
    public int trailingZeroes(int A) {
        int result = 0;
        for (int i = 1; A > Math.pow(5, i); i++) {
            result = +A / ((int) Math.pow(5, i));
        }
        return result;
    }
}
