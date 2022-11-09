package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;

public class KthRowOfPascalTriangle {

    public static void main(String[] args) {

        ArrayList<Integer> a = new KthRowOfPascalTriangle().getRow(4);
        System.out.println("Result = " + a);
    }

    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);

        for (int i =0; i<A;i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 1;j<result.size();j++){
                temp.add(result.get(j-1)+result.get(j));
            }
            temp.add(1);
            result = temp;
        }

        return result;
    }
}
