package com.amakhnev.problems.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {

    public static void main(String[] args) {
        System.out.println("result = " + new AllocateBooks().books(
                new ArrayList<>(Arrays.asList(31, 14, 19, 75 )),4
        ));
    }

    public int books(ArrayList<Integer> A, int B) {
        if (A.size()<B){
            return -1;
        }

        long max =Integer.MIN_VALUE, sum=0;
        for (int value:A){
            sum+=value;
            max = Math.max(max,value);
        }


        long left = max, right = sum;
        while (left < right){
            long mid = left + (right - left) /2;
            if(getNumOfStudents(A, mid) >= B) {
                left = mid + 1;

            }
            else {
                right = mid;
            }
        }
        return (int) left;
    }

    public int getNumOfStudents(ArrayList<Integer> books, long pagesPerStudent){
        long tempSum = 0;
        int numOfStudents = 1;
        for(int i =0;i < books.size(); i++){
            tempSum += books.get(i);
            if(tempSum > pagesPerStudent){
                tempSum = books.get(i);
                numOfStudents++;
            }
        }
        return numOfStudents;
    }

}
