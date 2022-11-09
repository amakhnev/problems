package com.amakhnev.problems.interviewbit.strings;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println("result = " + new CountAndSay().countAndSay(7));
    }

    public String countAndSay(int A) {
        if (A==1){
            return "1";
        }
        String prev = countAndSay(A-1);
        StringBuilder sb = new StringBuilder();
        int idx =0;
        while (idx<prev.length()){
            int counter = 0;
            char charToCompare = prev.charAt(idx);
            while (idx<prev.length() && charToCompare == prev.charAt(idx)){
                counter++;
                idx++;
            }
            sb.append(counter);sb.append(charToCompare);
        }
        return sb.toString();
    }

}
