package com.amakhnev.problems.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array3Pointers {


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 4, 10));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(2, 15, 20));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(10, 12));

        System.out.println("Result = " + new Array3Pointers().minimize(a, b, c));

    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int i = 0, j = 0, k = 0, minMax = Integer.MAX_VALUE;

        while (i < A.size() && j < B.size() && k < C.size()) {


            minMax = Math.min(minMax, Math.max(Math.max(Math.abs(A.get(i) - B.get(j)), Math.abs(B.get(j) - C.get(k))), Math.abs(C.get(k) - A.get(i))));

            if (A.get(i) <= Math.min(B.get(j), C.get(k))) {
                i++;
                continue;
            }
            if (B.get(j) <= Math.min(A.get(i), C.get(k))) {
                j++;
                continue;
            }
            if (C.get(k) <= Math.min(A.get(i), B.get(j))) {
                k++;
                continue;
            }
        }
        return minMax;
    }
}




