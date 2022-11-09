package com.amakhnev.problems.interviewbit.strings;

import java.util.ArrayList;
import java.util.Collections;

public class ValidIpAddresses {


    public static void main(String[] args) {
        System.out.println("Result = " + new ValidIpAddresses().restoreIpAddresses("0100100"));
    }

    public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> result = new ArrayList<>();
        if (A.length()<4){
            return result;
        }
        String regex = "25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]"; // 03 is not allowed!
        for (int i=1;i<A.length()-2;i++){
            if (A.substring(0,i).matches(regex)){
                for (int j=i+1;j<A.length()-1;j++){
                    if (A.substring(i,j).matches(regex)){
                        for (int k=j+1;k<A.length();k++){
                            if (A.substring(j,k).matches(regex) && A.substring(k,A.length()).matches(regex)){
                                result.add(A.substring(0,i)+"."+A.substring(i,j)+"."+A.substring(j,k)+"."+A.substring(k,A.length()));
                            }
                        }
                    }
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
