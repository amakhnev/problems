package com.amakhnev.problems.interviewbit.hashing;

import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        System.out.println(new Anagrams().anagrams(Arrays.asList(
                "cat tca dog god notcat cat".split(" ")
        )));
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String, ArrayList<Integer>> result = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            char[] strArr = A.get(i).toCharArray();
            Arrays.sort(strArr);
            String str = new String(strArr);

            if (result.containsKey(str)) {
                result.get(str).add(i + 1);
            } else {
                result.put(str, new ArrayList<>(Arrays.asList(i + 1)));
            }
        }
        return new ArrayList<>(result.values());
    }


}
