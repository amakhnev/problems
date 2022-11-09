package com.amakhnev.problems.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class PaintersPartitionProblem {

    public static void main(String[] args) {
        System.out.println("result = " +
                new PaintersPartitionProblem().paint(3,5,new ArrayList<>(Arrays.asList(100,1000,1000,1000))));
    }



    public int paint(int A, int B, ArrayList<Integer> C) {
        int M = 10000003;
        long sum =0; long max =Integer.MIN_VALUE;
        for (int length:C){
            max = Math.max(max,length);
            sum+=(long)length;
        }

        long left = max; long right = sum;

        while (left < right){
            long mid = (left + (right-left)/2);

            if(getRequiredPainters(C, mid) <= A) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return (int) ((left*B) % M);
    }

    public int getRequiredPainters(ArrayList<Integer> C,  long maxLengthPerPainter){
        int total = 0;
        int numOfPainters = 1;
        for(int i =0;i < C.size(); i++){
            total += C.get(i);
            if(total > maxLengthPerPainter){
                total = C.get(i);
                numOfPainters++;
            }
        }
        return numOfPainters;
    }

}
