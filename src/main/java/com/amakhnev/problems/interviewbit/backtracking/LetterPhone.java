package com.amakhnev.problems.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class LetterPhone {

    public static void main(String[] args) {
        System.out.println(new LetterPhone().letterCombinations("075076"));
    }


    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> result = new ArrayList<>();

        int number = A.charAt(0) - '0';
        for (char c : map(number)) {
            if (A.length() > 1) {
                for (String s : letterCombinations(A.substring(1))) {
                    result.add(String.valueOf(c) + s);
                }
            } else {
                result.add(String.valueOf(c));
            }
        }

        Collections.sort(result);
        return result;
    }


    public char[] map(int num) {
        switch (num) {
            case 0:
                return "0".toCharArray();
            case 1:
                return "1".toCharArray();
            case 2:
                return "abc".toCharArray();
            case 3:
                return "def".toCharArray();
            case 4:
                return "ghi".toCharArray();
            case 5:
                return "jkl".toCharArray();
            case 6:
                return "mno".toCharArray();
            case 7:
                return "pqrs".toCharArray();
            case 8:
                return "tuv".toCharArray();
            case 9:
                return "wxyz".toCharArray();
        }
        return new char[]{};
    }
}
