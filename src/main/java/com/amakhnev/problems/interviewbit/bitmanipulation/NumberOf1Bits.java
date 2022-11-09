package com.amakhnev.problems.interviewbit.bitmanipulation;

public class NumberOf1Bits {

    public static void main(String[] args) {

        System.out.println("Result = " + new NumberOf1Bits().numSetBits(127));
    }


    public int numSetBits(long a) {
        int counter = 0;
        while (a > 0) {
            counter += a & 1;
            a = a >> 1;
        }
        return counter;
    }

}
