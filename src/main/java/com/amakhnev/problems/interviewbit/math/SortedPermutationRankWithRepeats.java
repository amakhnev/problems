package com.amakhnev.problems.interviewbit.math;

import java.math.BigInteger;
import java.util.HashMap;

public class SortedPermutationRankWithRepeats {
    public static void main(String[] args) {
        System.out.println("Result = " + new SortedPermutationRankWithRepeats().findRank("asasdsdsadasdadsadasdsa"));
    }

    public int findRank(String A) {
        int M = 1000003;

        if (A.length() == 1) {
            return 1;
        }

        int numOffSmaller = 0;
        HashMap<Character, Integer> duplicates = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) < A.charAt(0)) {
                numOffSmaller++;
            }
            duplicates.put(A.charAt(i), duplicates.containsKey(A.charAt(i)) ? duplicates.get(A.charAt(i)) + 1 : 1);
        }

        return (getPrevFor(A.length(), numOffSmaller, duplicates, M) + findRank(A.substring(1))) % M;

    }

    private int getPrevFor(int numtotal, int numOfSmaller, HashMap<Character, Integer> duplicates, int M) {
        // (n-1)! * numOfSmaller / (all p! where p = value in duplicates)
        BigInteger temp = fact(numtotal - 1).multiply(BigInteger.valueOf(numOfSmaller));

        for (int value :
                duplicates.values()) {
            temp = temp.divide(fact(value));
        }
        return temp.mod(BigInteger.valueOf(M)).intValue();
    }

    private BigInteger fact(int n) {
        // Initialize result
        BigInteger f = BigInteger.ONE;
        // Multiply f with 2, 3, ...N
        for (int i = 2; i <= n; i++)
            f = f.multiply(BigInteger.valueOf(i));
        return f;
    }
}
