package com.amakhnev.problems.interviewbit.math;

public class PalindromeInteger {
    public int isPalindrome(int A) {
        String test = "" + A;
        for (int i = 0; i < test.length(); i++) {
            if (test.charAt(i) != test.charAt(test.length() - 1 - i)) {
                return 0;
            }
        }
        return 1;
    }

}
