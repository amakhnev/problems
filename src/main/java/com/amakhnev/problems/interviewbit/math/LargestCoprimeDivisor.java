package com.amakhnev.problems.interviewbit.math;

public class LargestCoprimeDivisor {

    public int cpFact(int A, int B) {
        int result = 1;

        for (int i = 1; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                if (gcd_fast(A / i, B) == 1) {
                    return A / i;
                } else {
                    if (gcd_fast(i, B) == 1) {
                        result = i;
                    }
                }
            }
        }

        return result;
    }

    private int gcd_fast(int a, int b) {
        if (a < b) {
            return gcd_fast(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd_fast(b, a % b);
    }
}
