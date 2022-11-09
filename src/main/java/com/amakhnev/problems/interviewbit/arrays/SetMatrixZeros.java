package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeros {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>(Arrays.asList(1,0)));
        result.add(new ArrayList<>(Arrays.asList(1,1)));

        new SetMatrixZeros().setZeroes(result);
        System.out.println("result = " + result);

    }


    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        for (int i=0;i<a.size();i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(i).set(0, a.get(i).get(0) + 10);
                    break;
                }
            }
        }
        for (int j=0;j<a.get(0).size();j++) {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).get(j) % 10 == 0) {
                    a.get(0).set(j, a.get(0).get(j) + 100);
                    break;
                }
            }
        }



        for (int i=1;i<a.size();i++){
            for (int j=1;j<a.get(i).size();j++){
                if (a.get(i).get(0)>=10 || a.get(0).get(j)>=100){
                    a.get(i).set(j,0);
                }
            }
        }
        for (int i=a.size()-1;i>=1;i--) {
           if (a.get(i).get(0)>=10 || a.get(0).get(0)>=100){
               a.get(i).set(0,0);
           }
        }
        for (int j=a.get(0).size()-1;j>=0;j--) {
            if (a.get(0).get(j)>=10 || a.get(0).get(0)%100>=10 ){
                a.get(0).set(j,0);
            }
        }

    }
}
