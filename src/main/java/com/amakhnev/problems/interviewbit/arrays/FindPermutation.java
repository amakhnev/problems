package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;

public class FindPermutation {

    public static void main(String[] args) {
        System.out.println("Result = " + new FindPermutation().findPerm("DDDID",6));
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> available = new ArrayList<>();
        for (int i=1;i<=B;i++){
            available.add(i);
        }


        ArrayList<Integer> result = new ArrayList<>();

        char[] sArr = A.toCharArray();

        for (int i=0;i<sArr.length;i++){
            char direction = sArr[i];

            if (direction == 'D'){
                    result.add(available.get(available.size()-1));
                    available.remove(available.size()-1);
            }else{ // direction = I
                result.add(available.get(0));
                available.remove(0);

            }

        }

        result.add(available.get(0));

        return result;
    }
}
