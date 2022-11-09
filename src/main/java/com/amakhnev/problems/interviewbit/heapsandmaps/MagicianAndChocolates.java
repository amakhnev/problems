package com.amakhnev.problems.interviewbit.heapsandmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    public static void main(String[] args) {
        System.out.println(new MagicianAndChocolates().nchoc(
                10,new ArrayList<>(Arrays.asList(2147483647, 2000000014, 2147483647))
        ));
    }





    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> bags = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int b:B){
            bags.add(b);
        }
        int M = 1000000007;
        int result=0;

        for (int i=0;i<A;i++){
            int numOfItems =bags.poll();
            result=(result+numOfItems%M)%M;
            bags.add(numOfItems/2);
        }

        return result;
    }


}
