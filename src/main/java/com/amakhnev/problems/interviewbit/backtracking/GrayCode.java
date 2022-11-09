package com.amakhnev.problems.interviewbit.backtracking;

import java.util.ArrayList;

public class GrayCode {

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(5));
    }


    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result = new ArrayList<>();

        if (a == 1) {
            result.add(0);
            result.add(1);
        } else {
            ArrayList<Integer> prevResult = grayCode(a - 1);
            for (int i = 0; i < prevResult.size(); i++) {
                result.add(prevResult.get(i) << 1);
            }
            for (int j = prevResult.size() - 1; j >= 0; j--) {
                result.add((prevResult.get(j) << 1) + 1);
            }
        }

        return result;
    }
}
