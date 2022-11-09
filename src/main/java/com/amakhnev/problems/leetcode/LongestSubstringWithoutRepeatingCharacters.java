package com.amakhnev.problems.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println("Result = "+new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("safdsgfghghkjhkhgjkwertfghj"));
    }


    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int i=0,j=0,maxLen=0;
        while(j<s.length()&&i<s.length()){
            if (!chars.contains(s.charAt(j))){
                chars.add(s.charAt(j++));
                maxLen = Math.max(maxLen,j-i);
            }else {
                chars.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }

}
