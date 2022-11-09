package com.amakhnev.problems.interviewbit.heapsandmaps;

import java.math.BigInteger;
import java.util.HashMap;

public class WaysToFormMaxHeap {

    public static void main(String[] args) {
//        for (int i=1;i<=64;i++){
//            System.out.println("n="+i+",size of right subtree ="+new com.amakhnev.problems.interviewbit.heapsandmaps.WaysToFormMaxHeap().getRightTreeSize(i));
//        }
        System.out.println(new WaysToFormMaxHeap().solve(54));
    }

    int M = 1000000007;
    HashMap<Integer,Integer> values = new HashMap<>();
    HashMap<Integer, BigInteger> factorials = new HashMap<>();

    public int solve(int A) {
        if (A<=2){
            return 1;
        }
        if (values.containsKey(A)){
            return  values.get(A);
        }

        int m = getRightTreeSize(A);
        //number of all possible combinations of numbers.
        long result = getCombination(A-1,m);
        // add right tree
        result = (result * (solve(m) % M ) ) % M;
        // add left tree
        result = (result * (solve(A-1-m) % M ) ) % M;


        values.put(A, (int) result);
        return (int) result;
    }

    private int getRightTreeSize(int n) {
        int powTwo =1;
        while (powTwo-1-n<0){
            powTwo*=2;
        }
        int result = powTwo/4-1;
        if (powTwo-1-n<=powTwo/4){
            result+=powTwo/4+n+1-powTwo;
        }
        return result;
    }

    public int getCombination(int n,int m){
        if (factorials.size()<n){
            loadFactorials(n);
        }
        BigInteger combValue = factorials.get(n).divide(factorials.get(m)).divide(factorials.get(n-m));
        return combValue.mod(BigInteger.valueOf(M)).intValue();
    }

    private void loadFactorials(int n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i=0;i<=n;i++){
            if (!factorials.containsKey(i)){
                if (i>1) {
                    result = BigInteger.valueOf(i).multiply(factorials.get(i - 1));
                }
                factorials.put(i,result);
            }
        }
    }


}
