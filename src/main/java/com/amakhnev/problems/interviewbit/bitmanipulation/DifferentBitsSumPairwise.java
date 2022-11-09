package com.amakhnev.problems.interviewbit.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class DifferentBitsSumPairwise {

    public static void main(String[] args) {
        System.out.println("Result = " + new DifferentBitsSumPairwise().cntBits(new ArrayList(
                Arrays.asList(1,3,5)
        )));
    }

    public int cntBits(ArrayList<Integer> A) {
        int bitsCounter,n=A.size(),count;
        long result=0;

        for(bitsCounter=0;bitsCounter<32;bitsCounter++){
            count=0;
            for(int num : A){
                count+=(num>>bitsCounter)&1;
            }
            result=(result+(long)count*(n-count))%1000000007;
        }
        //need to multiply by 2. Let's do it in bits style :)
        result=(result<<1)%1000000007;

        return (int)result;
    }
}
