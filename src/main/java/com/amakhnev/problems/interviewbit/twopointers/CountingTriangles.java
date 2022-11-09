package com.amakhnev.problems.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountingTriangles {

    public static void main(String[] args) {
        System.out.println("Result = " + new CountingTriangles().nTriang(new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2))));
    }

    public int nTriang(ArrayList<Integer> A) {
        long result=0;
        Collections.sort(A);

        for (int k=A.size()-1;k>1;k--){
            int i=0, j=k-1;

            while (i<j){
                if (A.get(i)+A.get(j)>A.get(k)){
                    result+=(j-i);
                    j--;
                }else{
                    i++;
                }
            }
        }
        return (int)(result % 1000000007);
    }

}
