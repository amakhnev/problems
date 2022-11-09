package com.amakhnev.problems.interviewbit.backtracking;

import java.util.ArrayList;

public class KthPermutationSequence {

    public static void main(String[] args) {
        System.out.println(new KthPermutationSequence().getPermutation(12, 1));
    }


    public String getPermutation(int A, int B) {

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> numbers = new ArrayList();
        ArrayList<Integer> factorials = new ArrayList<>();
        factorials.add(1);
        for (int i = 1; i <= A; i++) {
            numbers.add(i);
            if (i > 1 && i < A) {
                if (factorials.get(i - 2) > Integer.MAX_VALUE / i) {
                    factorials.add(Integer.MAX_VALUE);
                } else {
                    factorials.add(factorials.get(i - 2) * i);
                }
            }
        }
        B--; // need to subtract 1 as we counting permutations starting from 1, not from 0.


        for (int i = A - 1; i > 0 && B > 0; i--) {
            int num = B / factorials.get(i - 1);
            B = B % factorials.get(i - 1);
            sb.append(numbers.get(num));
            numbers.remove(num);
        }

        for (int num : numbers) {
            sb.append(num);
        }
        return sb.toString();
    }

}
