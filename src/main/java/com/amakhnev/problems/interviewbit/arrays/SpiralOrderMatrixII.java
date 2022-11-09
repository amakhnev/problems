package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;

public class SpiralOrderMatrixII {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> a = new SpiralOrderMatrixII().generateMatrix(5);
        System.out.println("Result = " + a);
    }


    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            result.add(new ArrayList<>());
        }
        if (A <= 0) {
            return result;
        }
        int counter = A;
        int currentEl = 1;

        while (counter > 1) {
            int offset = (A - counter) / 2;
            for (int i = 0; i < counter - 1; i++) { // top left to top right
                result.get(offset).add(offset + i, currentEl++);
            }
            for (int i = 0; i < counter - 1; i++) { // top right to bottom right
                result.get(i + offset).add(result.get(i + offset).size() - offset, currentEl++);
            }
            for (int i = 0; i < counter - 1; i++) { // bottom right to bottom left
                result.get(A - 1 - offset).add(result.get(A - 1 - offset).size() - offset - i, currentEl++);
            }
            for (int i = 0; i < counter - 1; i++) { // bottom left to top left
                result.get(A - 1 - offset - i).add(offset, currentEl++);
            }
            counter -= 2;
        }
        if (counter == 1) {
            result.get(A / 2).add(A / 2, currentEl);
        }
        return result;
    }


}
