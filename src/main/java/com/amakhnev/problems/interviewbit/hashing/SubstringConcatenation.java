package com.amakhnev.problems.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringConcatenation {

    public static void main(String[] args) {
        System.out.println(new SubstringConcatenation().findSubstring(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("aaa", "aaa", "aaa", "aaa", "aaa")
        ));
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        ArrayList<Integer> result = new ArrayList<>();
        int wordsLength = B.get(0).length(), subLength = wordsLength * B.size();
        mainLoop:
        for (int i = 0; i < A.length() - subLength + 1; i++) {
            List candidates = new ArrayList(B);
            for (int j = 0; j < subLength; j += wordsLength) {
                String word = A.substring(i + j, i + j + wordsLength);
                if (candidates.contains(word)) {
                    candidates.remove(word);
                } else {
                    continue mainLoop;
                }
            }
            result.add(i);
        }
        return result;
    }
}
