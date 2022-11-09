package com.amakhnev.problems.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

    public static void main(String[] args) {

        System.out.println(new Permutations().permute(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4))
        ));
    }


    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A.size() == 1) {
            result.add(new ArrayList<>(Arrays.asList(A.get(0))));
        } else {
            for (int num : A) {
                ArrayList<Integer> newA = new ArrayList<>(A);
                newA.remove(new Integer(num));
                ArrayList<ArrayList<Integer>> newres = permute(newA);
                for (ArrayList<Integer> item : newres) {
                    item.add(0, num);
                    result.add(item);
                }
            }
        }
        return result;
    }
}
