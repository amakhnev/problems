package com.amakhnev.problems.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSumII {


    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum(
                new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5)), 8
        ));
    }


    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        return combine(a, 0, b);
    }

    private ArrayList<ArrayList<Integer>> combine(ArrayList<Integer> candidates, int startIdx, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = startIdx; i < candidates.size(); i++) {
            int num = candidates.get(i);
            if (num - target == 0) {
                ArrayList<Integer> combination = new ArrayList<>(Arrays.asList(num));
                if (!result.contains(combination))
                    result.add(combination);
            } else if (num < target) {
                ArrayList<ArrayList<Integer>> combinations = combine(candidates, i + 1, target - num);
                for (ArrayList<Integer> combination : combinations) {
                    combination.add(0, num);
                    if (!result.contains(combination))
                        result.add(combination);
                }
            } else {
                break;
            }
        }
        return result;
    }


}
