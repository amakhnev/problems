package com.amakhnev.problems.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumZero {

    public static void main(String[] args) {
        System.out.println("Result = " + new ThreeSumZero().threeSum(new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4))));
    }


    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current;
        Collections.sort(A);

        for (int i=0;i<A.size()-2;i++){
            int j=i+1,k=A.size()-1;
            while (j<k){
                if (A.get(i)+A.get(j)+A.get(k)==0){
                    current = new ArrayList<>(Arrays.asList(A.get(i),A.get(j),A.get(k)));
                    if (!result.contains(current)) {
                        result.add(current);
                    }
                }
                if (A.get(i)+A.get(j)+A.get(k)>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}
