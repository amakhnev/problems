package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveArray {



    public static void main(String[] args) {
        System.out.println(new WaveArray().wave(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6))));
    }



    public ArrayList<Integer> wave(ArrayList<Integer> A) {

        ArrayList<Integer> result = new ArrayList<>(A);
        Collections.sort(result);
        for (int i=0;i<result.size()/2;i++){
            // swap 2*i ans 2*i+1
            int temp = result.get(2*i);
            result.set(2*i,result.get(2*i+1));
            result.set(2*i+1,temp);
        }
        return result;
    }


}
