package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;

public class AddOneToNumber {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();

        a.add(0);
        a.add(1);
        a.add(2);
        a.add(3);

        System.out.println("Result = " + new AddOneToNumber().plusOne(a));
    }


    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> result = (ArrayList<Integer>) A.clone();

        //increase
        boolean needIncrease = true;
        int current = A.size()-1;

        while (needIncrease && current >= 0){
            result.set(current,(A.get(current)+1)%10);
            if (A.get(current)!=9){
                needIncrease = false;
            }
            current--;
        }

        if (needIncrease){
            result.add(0,1);
        }

        //reduce
        while(result.size()>0 && result.get(0)==0){
            result.remove(0);
        }

        return result;


    }

}
