package com.amakhnev.problems.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class CombinationSum {


    public static void main(String[] args) {

        System.out.println(new CombinationSum().combinationSum(
                new ArrayList(Arrays.asList(8, 5, 12, 10, 20, 18, 13, 18, 16, 3)), 28
        ));
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        Collections.sort(A);
        // remove duplicates
        Integer prev = null;
        for (Iterator<Integer> it = A.iterator(); it.hasNext(); ) {
            int current = it.next();
            if (prev != null && current - prev == 0) {
                it.remove();
            }
            prev = current;
        }

        return combine(A, 0, B);
    }

    public ArrayList<ArrayList<Integer>> combine(ArrayList<Integer> candidates, int curIdx, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = curIdx; i < candidates.size(); i++) {
            int num = candidates.get(i);
            if (num - target == 0) {
                result.add(new ArrayList<>(Arrays.asList(num)));
            } else if (num < target) {
                ArrayList<ArrayList<Integer>> combs = combine(candidates, i, target - num);
                for (ArrayList<Integer> comb : combs) {
                    comb.add(0, num);
                }
                if (combs.size() > 0) {
                    result.addAll(combs);
                }
            } else { // current num > target, hence all subsequent will be >target as well
                break;
            }
        }
        return result;
    }

}
