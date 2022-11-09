package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepeatAndMissingNumberArray {


    public static void main(String[] args) {
        int size = 10000;
        int missingNum = (int) (Math.random() * size) + 1;
        int extraNum;
        do {
            extraNum = (int) (Math.random() * size) + 1;
        }
        while (extraNum ==missingNum);

        ArrayList<Integer> a = new ArrayList<>();

        for (int i=1;i<=size;i++){
            a.add(i==missingNum?extraNum:i);
        }
        Collections.shuffle(a);

        ArrayList<Integer> result = new RepeatAndMissingNumberArray().repeatedNumber(a);

        if (result.get(1)==missingNum && result.get(0)==extraNum){
            System.out.println("Correct! Missing num = "+ missingNum+", extra num = "+extraNum+".");
        }else{
            System.out.println("Wrong! Missing num = " + result.get(1)+", should be = "+ missingNum+", extra num = "+ result.get(0)+", should be = "+extraNum+".");
        }


    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int missingNum=0,extraNum=0;
        if(A.size()>1){
            int[] count = new int[A.size()];
            for (int num:A) {
                count[num-1]++;
            }

            for (int i=0;i<count.length;i++) {
                if (count[i]!=1){
                    if (count[i]==0){
                        missingNum = i+1;
                    }
                    if (count[i]==2){
                        extraNum= i+1;
                    }
                }
            }

        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(extraNum);result.add(missingNum);
        return result;
    }
}
