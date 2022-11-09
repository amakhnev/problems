package com.amakhnev.problems.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;


public class GenerateAllParenthesesII {

    public static void main(String[] args) {
        System.out.println(new GenerateAllParenthesesII().generateParenthesis(4));
    }


    public ArrayList<String> generateParenthesis(int A) {

        ArrayList<String> result = new ArrayList<>();

        for (StringBuilder sb : generateParenthesis(A * 2, 0)) {
            result.add(sb.toString());
        }

        Collections.sort(result);

        return result;
    }


    public ArrayList<StringBuilder> generateParenthesis(int length, int numOfOpen) {

        ArrayList<StringBuilder> result = new ArrayList<>();

        if (length == 1 && numOfOpen == 1) {
            result.add(new StringBuilder(")"));
        } else {
            if (length > 1) {
                if (numOfOpen < length) {
                    for (StringBuilder sb : generateParenthesis(length - 1, numOfOpen + 1)) {
                        sb.insert(0, "(");
                        result.add(sb);
                    }
                }
                if (numOfOpen > 0) {
                    for (StringBuilder sb : generateParenthesis(length - 1, numOfOpen - 1)) {
                        sb.insert(0, ")");
                        result.add(sb);
                    }
                }

            }
        }

        return result;
    }

}
