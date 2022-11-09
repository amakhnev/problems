package com.amakhnev.problems.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(2, 9, 12, 13, 16, 18, 18, 19, 20, 22)));
        input.add(new ArrayList<>(Arrays.asList(29, 59, 62, 66, 71, 75, 77, 79, 97, 99)));

        System.out.println("result = " + new MatrixSearch().searchMatrix(input,23));
    }

    public int getValue(ArrayList<ArrayList<Integer>> a, int k, int m){
        return a.get(k/m).get(k%m);
    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int n = a.size(); int m = a.get(0).size();

        int min = 0, max = n*m-1;

        if (getValue(a,min,m) > b || getValue(a,max,m) < b){
            return 0;
        }

        while (min<=max){
            int mid = min + (max-min) / 2;
            int midvalue = getValue(a,mid,m);
            if (midvalue==b){
                return 1;
            }
            if (midvalue<b){
                min = mid+1;
            }else{
                max= mid-1;
            }
        }

        return 0;
    }
}
