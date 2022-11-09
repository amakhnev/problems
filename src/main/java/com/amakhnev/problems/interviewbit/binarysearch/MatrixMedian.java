package com.amakhnev.problems.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixMedian {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        input.add(new ArrayList<>(Arrays.asList(1,3,5)));
        input.add(new ArrayList<>(Arrays.asList(2,6,9)));
        input.add(new ArrayList<>(Arrays.asList(3,6,9)));

        System.out.println("Result = " + new MatrixMedian().findMedian(input));
    }


    public int findMedian(ArrayList<ArrayList<Integer>> A) {

        int min = A.get(0).get(0), max = A.get(0).get(0);
        int n = A.size(), m = A.get(0).size();
        for (int i = 0; i < n; ++i) {
            if (A.get(i).get(0) < min) min = A.get(i).get(0);
            if (A.get(i).get(m-1) > max) max = A.get(i).get(m-1);
        }

        int element = (n * m + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int cnt = 0;
            for (int i = 0; i < n; ++i)
                cnt += numOfLessOrEqual(A.get(i),mid);
            if (cnt < element)
                min = mid + 1;
            else
                max = mid;
        }
        return min;

    }

    public int numOfLessOrEqual(ArrayList<Integer> A,int B){
        int left =0;int right = A.size();

        while (left<right){
            int mid = (left + right )/ 2;
            if (A.get(mid)>B){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
