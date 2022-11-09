package com.amakhnev.problems.interviewbit.strings;

public class IntegerToRoman {


    public static void main(String[] args) {
        System.out.println("Result = " + new IntegerToRoman().intToRoman(19));
    }

    public String intToRoman(int A) {
        StringBuilder sb = new StringBuilder();


        int [] numbers = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] letters = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i=0;i<numbers.length;i++){
            while (A / numbers[i] >0){
                sb.append(letters[i]);
                A -=numbers[i];
            }
        }


        return sb.toString();

    }

}
