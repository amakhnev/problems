package com.amakhnev.problems.interviewbit.strings;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println("Result = " + new LengthOfLastWord().lengthOfLastWord(" world  s"));
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        int prev =0, current =0, idx=0;
        while (idx<A.length()){
            if (A.charAt(idx) == ' '){
                if (current>0){
                    prev = current;
                }
                current=0;
            }else{
                current++;
            }
            idx++;
        }
        return current>0?current:prev;
    }
}
