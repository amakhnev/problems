package com.amakhnev.problems.interviewbit.backtracking;

import java.util.ArrayList;

public class Sudoku {

    public static void main(String[] args) {
        String[] rows = new String[]{
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"};
        ArrayList<ArrayList<Character>> input = new ArrayList<>();
        for (String row : rows) {
            ArrayList<Character> inputRow = new ArrayList<>();
            for (char c : row.toCharArray()) {
                inputRow.add(c);
            }
            input.add(inputRow);
        }
        new Sudoku().solveSudoku(input);

        System.out.println(input);

    }

    public final char[] POSSIBLE_CHARS = "123456789".toCharArray();
    public final char SPACE_CHAR = '.';
    public boolean isSolved = false;

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {


        // find next unoccupied space
        int row = -1, column = -1;
        nextLoop:
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == SPACE_CHAR) {
                    row = i;
                    column = j;
                    break nextLoop;
                }
            }
        }
        if (row < 0) {
            isSolved = true;
            return;
        }

        // find all possible candidates
        ArrayList<Character> candidates = new ArrayList<>();
        for (char c : POSSIBLE_CHARS) {
            if (!a.get(row).contains(c)) {
                candidates.add(c);
            }
        }
        candidatesLoop:
        for (char candidate : candidates) {
            // check if can be placed into the place
            //check column first
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).get(column) == candidate) {
                    continue candidatesLoop;
                }
            }
            // check square
            for (int i = 3 * (row / 3); i < 3 * (row / 3) + 3; i++) {
                for (int j = 3 * (column / 3); j < 3 * (column / 3) + 3; j++) {
                    if (a.get(i).get(j) == candidate) {
                        continue candidatesLoop;
                    }
                }
            }

            // number can be placed, try to solve recursively
            a.get(row).set(column, candidate);
            solveSudoku(a);
            if (isSolved) {
                return;
            }

            // remove conflicting number
            a.get(row).set(column, SPACE_CHAR);
        }

    }


}
