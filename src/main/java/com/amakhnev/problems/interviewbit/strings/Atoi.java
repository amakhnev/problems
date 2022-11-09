package com.amakhnev.problems.interviewbit.strings;

public class Atoi {

    public static void main(String[] args) {

        System.out.println("result = " + new Atoi().atoi(" +12344444444435gff 33435"));
    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String A) {
        String[] sArr = A.trim().split("[^-+0-9]");

        if (sArr.length > 0 && sArr[0].matches("(\\+|-)?[0-9]+")) {
            try {
                return Integer.parseInt(sArr[0]);
            } catch (NumberFormatException e) {
                return sArr[0].startsWith("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return 0;
    }

}
