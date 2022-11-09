package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AntiDiagonals {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>(Arrays.asList(1,2,3));
        input.add(row);
        row = new ArrayList<>(Arrays.asList(4,5,6));
        input.add(row);
        row = new ArrayList<>(Arrays.asList(7,8,9));
        input.add(row);


        System.out.println("Result = " + new AntiDiagonals().diagonal(input));
    }



    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i=0;i<2*A.size()-1;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            int startRow,startColumn,size;
            if (i<A.size()){
                startRow = 0;startColumn=i;size = i;
            }else{
                startRow = i-A.size()+1;startColumn=A.size()-1;size = 2*A.size()-2-i;
            }
            for (int j=0;j<=size;j++){
                temp.add(A.get(startRow+j).get(startColumn-j));
            }
            result.add(temp);
        }

        return result;
    }
}
