package com.amakhnev.problems.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {

    public static void main(String[] args) {

        System.out.println("Result = " + new Subset().subsets(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4))
        ));

    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        result.add(new ArrayList<>());

        for (int i = A.size() - 1; i >= 0; i--) {
            ArrayList<ArrayList<Integer>> newPerms = new ArrayList<>();
            for (ArrayList<Integer> perm : result) {
                ArrayList<Integer> newPerm = new ArrayList<>(perm);
                newPerm.add(0, A.get(i));
                newPerms.add(newPerm);
            }
            result.addAll(1, newPerms);
        }
        return result;
    }


}
