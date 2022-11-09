package com.amakhnev.problems.interviewbit.stacksandqueues;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {
        System.out.println("Result = "+new RedundantBraces().braces("((2+3)-)"));
    }


    public int braces(String A) {
        Stack<Character> bracesAndOperations = new Stack<>();

        for (char a:A.toCharArray()){
            if (a=='('){
                bracesAndOperations.push(a);
                continue;
            }
            if (isOperator(a)){
                char prev = bracesAndOperations.empty()?'.':bracesAndOperations.peek();
                if (prev=='(') {
                    bracesAndOperations.push(a);
                }
                continue;
            }
            if (a==')'){
                char prev = bracesAndOperations.empty()?'.':bracesAndOperations.pop();
                if (!isOperator(prev)){
                    return 1;
                }
                char prevBrace = bracesAndOperations.empty()?'.':bracesAndOperations.pop();
                if (prevBrace!='('){
                    return 1;
                }
            }
        }
        return bracesAndOperations.empty()?0:1;
    }

    public boolean isOperator(char c){
        return c=='+' || c=='-' || c=='*' || c=='/';
    }

}
