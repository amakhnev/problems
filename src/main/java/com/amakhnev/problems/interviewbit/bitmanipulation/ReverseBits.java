package com.amakhnev.problems.interviewbit.bitmanipulation;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println("Result = " + new ReverseBits().reverse(1));
    }



    public long reverse(long a) {
        long result = a & 1;
        for (int i = 0; i < 31; i++) {
            result <<= 1;
            a >>>= 1;
            result |= a & 1;
        }
        return result;
    }

}
