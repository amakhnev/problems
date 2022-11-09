package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;

public class PascalTriangle {


    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> a = new PascalTriangle().generate(2);
        System.out.println("Result = " + a);
    }

    public ArrayList<ArrayList<Integer>> generate(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i=0;i<A;i++) {
            ArrayList<Integer> subArray = new ArrayList<>();
            for (int j=0;j<=i;j++) {
                if (j==0 || j==i) {
                    subArray.add( 1);
                }else {
                    subArray.add(result.get(i-1).get(j-1)+ result.get(i-1).get(j));
                }
            }
            result.add(subArray);
        }
        return result;
    }

}
