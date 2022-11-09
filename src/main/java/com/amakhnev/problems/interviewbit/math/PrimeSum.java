package com.amakhnev.problems.interviewbit.math;

import java.util.ArrayList;

public class PrimeSum {

    public static void main(String[] args) {
        System.out.println(new PrimeSum().primesum(16777214));
    }


    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; i <= A / 2; i++) {
            if (isPrime(i) && isPrime(A - i)) {
                result.add(i);
                result.add(A - i);
                return result;
            }
        }
        return result;
    }

    private boolean isPrime(int num) {

        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
