package com.amakhnev.problems.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println("Result = " + new ThreeSum().threeSumClosest(new ArrayList<>(Arrays.asList(5, -2, -1, -10, 10)), 5));

    }


    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);

        int j, k;
        long minSum = A.get(0) + A.get(1) + A.get(2), currSum;
        for (int i = 0; i < A.size() - 2; i++) {
            j = i + 1;
            k = A.size() - 1;
            while (j < k) {
                currSum = A.get(i) + A.get(j) + A.get(k);
                if (currSum - B == 0) {
                    return B;
                }
                if (Math.abs(minSum - B) > Math.abs(currSum - B)) {
                    minSum = currSum;
                }
                if (currSum > B) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return (int) minSum;
    }
}
