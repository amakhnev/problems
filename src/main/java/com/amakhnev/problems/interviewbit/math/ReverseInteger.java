package com.amakhnev.problems.interviewbit.math;

public class ReverseInteger {
    public int reverse(int A) {
        boolean isNegative = (A < 0);
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(A));
        if (isNegative) {
            sb.append("-");
        }
        int result = 0;

        try {
            result = Integer.parseInt(sb.reverse().toString());
        } catch (Exception e) {
        }

        return result;
    }
}
