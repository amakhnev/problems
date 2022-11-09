package com.amakhnev.problems.interviewbit.binarysearch;

public class SquareRootOfInteger {

    public static void main(String[] args) {
        System.out.println("Value = " + new SquareRootOfInteger().sqrt(2147483647));
    }

    public int sqrt(int a) {
        long left = 0, right = (long)a+1;

        while (left < right -1){
            long mid =  (right + left) / 2;
            if ((long) mid * mid > a){
                right = mid;
            } else {
                left = mid;
            }
        }

        return (int)left;

    }
}
