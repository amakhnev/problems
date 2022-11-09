package com.amakhnev.problems.interviewbit.math;

public class GreatestCommonDivisor {
    public int gcd(int A, int B) {

        int result = 0;
        for (int i = 1; i <= Math.min(A, B); i++) {

            if (A % i == 0 && B % i == 0) {
                result = i;
            }
        }
        return result;
    }
}
