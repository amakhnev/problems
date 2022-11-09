package com.amakhnev.problems.interviewbit.math;

public class ExcelColumnNumber {

    public static void main(String[] args) {
        System.out.println("titleToNumber = " + new ExcelColumnNumber().titleToNumber("XFD"));
    }

    public int titleToNumber(String A) {


        int result = 0;
        char[] charArray = A.toUpperCase().toCharArray();

        for (int i = charArray.length - 1; i >= 0; i--) {

            int cNum = charToNum(charArray[i]);
            if (cNum > 0) {
                result = result + (int) Math.pow(26, charArray.length - 1 - i) * cNum;
            } else {
                return 0;
            }
        }
        return result;
    }

    private int charToNum(char c) {

        int temp_integer = 64; // used to transfer uppercase characters to int
        int temp = (int) c;

        if (temp <= 90 & temp >= 65) {
            return temp - temp_integer;
        }
        return 0;
    }
}
