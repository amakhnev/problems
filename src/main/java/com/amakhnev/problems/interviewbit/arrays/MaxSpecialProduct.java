package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxSpecialProduct {

    public static void main(String[] args) {
        System.out.println("Result = "+new MaxSpecialProduct().maxSpecialProduct(new ArrayList<>(Arrays.asList( 6, 5, 4, 9, 9, 6, 5, 4, 5, 9, 9))));
    }


    public int maxSpecialProduct(ArrayList<Integer> A) {
        int M = 1000000007;
        long maxSP =0;

        Stack<Integer[]> maximums = new Stack<>();
        int[] leftMaxs = new int[A.size()];
        for (int i=0;i<A.size();i++){
            while(!maximums.empty() && maximums.peek()[0]<=A.get(i)){
                maximums.pop();
            }
            leftMaxs[i] = maximums.empty()?0:maximums.peek()[1];

            maximums.push(new Integer[]{A.get(i),i});
        }

        int[] rightMaxs = new int[A.size()];
        maximums.removeAllElements();
        for (int i=A.size()-1;i>=0;i--){
            while(!maximums.empty() && maximums.peek()[0]<=A.get(i)){
                maximums.pop();
            }
            rightMaxs[i] = maximums.empty()?0:maximums.peek()[1];
            maximums.push(new Integer[]{A.get(i),i});
        }



        for (int i=1;i<A.size()-1;i++){
            maxSP = Math.max(maxSP, (long)leftMaxs[i]*rightMaxs[i]);
        }

        return (int)(maxSP % M);
    }
}
