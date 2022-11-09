package com.amakhnev.problems.interviewbit.arrays;

import java.util.*;

public class HotelBookingsPossible {

    public static void main(String[] args) {
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2, 3, 4));
        System.out.println("Result = "+ new HotelBookingsPossible().hotel(arrive,depart,1));
    }


    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        HashMap<Integer,Integer> combined = new HashMap<>();

        for (int i=arrive.size()-1;i>=0;i--){
            if (arrive.get(i)>=depart.get(i)){
                arrive.remove(i);depart.remove(i);
            }else{
                if (combined.containsKey(arrive.get(i))){
                    combined.replace(arrive.get(i),combined.get(arrive.get(i))+1);
                }else{
                    combined.put(arrive.get(i),1);
                }

                if (combined.containsKey(depart.get(i))){
                    combined.replace(depart.get(i),combined.get(depart.get(i))-1);
                }else{
                    combined.put(depart.get(i),-1);
                }

            }
        }

        Integer [] keys = combined.keySet().toArray(new Integer[]{});
        Arrays.sort(keys);


        int guests=0;

        for (int i=0;i<keys.length;i++){
            guests +=combined.get(keys[i]);
            if (guests>K){
                return false;
            }
         }
        return true;
    }


}
