package com.amakhnev.problems.interviewbit.strings;

public class ImplementStrStr {


    public static void main(String[] args) {
        System.out.println("Result  = " + new ImplementStrStr().strStr("baba","b"));
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        if (B.length()==0|| A.length()<B.length()){
            return -1;
        }

        for (int i=0; i<= A.length() - B.length();i++){
            if (A.substring(i,i+B.length()).equals(B)){
                return i;
            }
        }

        return -1;
    }

}
