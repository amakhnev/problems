package com.amakhnev.problems.interviewbit.strings;

public class AddBinaryStrings {

    public static void main(String[] args) {
        System.out.println("Result = " + new AddBinaryStrings().addBinary("10011","10001111"));
    }

    public String addBinary(String A, String B) {
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        for (int i =0; i< Math.max(A.length(),B.length());i++){
            int numA = (i<A.length())?(A.charAt(A.length()-1-i)-'0'):0;
            int numB = (i<B.length())?(B.charAt(B.length()-1-i)-'0'):0;
            int result = numA+numB+(carry?1:0);
            carry = (result/2)>0;
            sb.append(result % 2);
        }
        if (carry){
            sb.append("1");
        }
        return sb.reverse().toString();
    }

}
