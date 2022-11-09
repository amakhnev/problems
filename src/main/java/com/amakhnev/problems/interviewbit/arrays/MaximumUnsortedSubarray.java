package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumUnsortedSubarray {


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,5));
        System.out.println("Result = "+new MaximumUnsortedSubarray().subUnsort(a));
    }

    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {

        if (A.size()<2){
            return new ArrayList<>(Arrays.asList(-1));
        }

        int minAfterBigger = Integer.MAX_VALUE;
        int maxBeforeLower = Integer.MIN_VALUE;

        int i=1;
        while (i<A.size() && A.get(i-1)<=A.get(i)){
            i++;
        }
        if (i!=A.size()){
            while (i<A.size()){
                minAfterBigger = Math.min(minAfterBigger,A.get(i));
                i++;
            }
        }else{
            return new ArrayList<>(Arrays.asList(-1));
        }

        int j=A.size()-1;
        while (j>0 && A.get(j)>=A.get(j-1)){
            j--;
        }

        if (j!=0){
            while (j>=0){
                maxBeforeLower = Math.max(maxBeforeLower,A.get(j));
                j--;
            }
        }else{
            return new ArrayList<>(Arrays.asList(-1));
        }

        int minIdx = 0;
        while (A.get(minIdx)<=minAfterBigger){
            minIdx++;
        }
        int maxIdx = A.size()-1;
        while (A.get(maxIdx)>=maxBeforeLower){
            maxIdx--;
        }

        return new ArrayList<>(Arrays.asList(minIdx,maxIdx));
    }


}
