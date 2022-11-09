package com.amakhnev.problems.interviewbit.math;

public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        StringBuilder result = new StringBuilder();
        int temp = A;

        while (temp > 0) {
            int reminder = temp % 26;
            result.append((char) (reminder + 64));
            temp = temp / 26;
        }

        return result.reverse().toString();
    }
}
