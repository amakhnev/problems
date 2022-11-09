package com.amakhnev.problems.interviewbit.math;

import java.util.Arrays;

public class SortedPermutationRank {
    public int findRank(String A) {

        int M = 1000003;

        if (A.length() == 1) {
            return 1;
        }
        char[] sA = A.toCharArray();
        Arrays.sort(sA);
        String sortedA = new String(sA);

        return ((sortedA.indexOf(A.charAt(0)) * factMod(A.length() - 1, M)) % M + findRank(A.substring(1)) % M) % M;

    }

    private int factMod(int i, int m) {
        if (i == 1)
            return 1;
        return ((i % m) * (factMod(i - 1, m) % m)) % m;
    }
}
