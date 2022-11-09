package com.amakhnev.problems.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetsII {

    public static void main(String[] args) {
        System.out.println(new SubsetsII().subsetsWithDup(
                new ArrayList<>(Arrays.asList(1, 2, 2))
        ));
    }


    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {

        Collections.sort(A);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = A.size() - 1; i >= 0; i--) {

            ArrayList<ArrayList<Integer>> newCombs = new ArrayList<>();
            for (ArrayList<Integer> combination : result) {
                ArrayList<Integer> newComb = new ArrayList<>(combination);
                newComb.add(0, A.get(i));
                newCombs.add(newComb);
            }
            for (ArrayList<Integer> combination : newCombs) {
                if (result.contains(combination)) {
                    result.remove(combination);
                }
            }
            result.addAll(1, newCombs);
        }


        return result;

    }


}
