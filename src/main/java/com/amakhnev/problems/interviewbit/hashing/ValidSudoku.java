package com.amakhnev.problems.interviewbit.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ValidSudoku {


    public static void main(String[] args) {
        System.out.println(new ValidSudoku().isValidSudoku(Arrays.asList("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79")));
    }


    public int isValidSudoku(final List<String> A) {
        HashMap<Integer,HashSet<Integer>> rows = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> columns = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> squares = new HashMap<>();


        // check each symbol
        for (int i=0;i<A.size();i++){
            for (int j=0;j<A.get(i).length();j++){
                if (A.get(i).charAt(j)!='.'){
                    int num = A.get(i).charAt(j)-'0';
                    //check rows
                    if (rows.containsKey(i)){
                        if (rows.get(i).contains(num)){
                            return 0;
                        }
                        rows.get(i).add(num);
                    }else{
                        HashSet<Integer> nums = new HashSet<>();
                        nums.add(num);
                        rows.put(i,nums);
                    }

                    //check columns
                    if (columns.containsKey(j)){
                        if (columns.get(j).contains(num)){
                            return 0;
                        }
                        columns.get(j).add(num);
                    }else{
                        HashSet<Integer> nums = new HashSet<>();
                        nums.add(num);
                        columns.put(j,nums);
                    }

                    //check squares
                    int squarenum = 3*(j/3)+i/3;
                    if (squares.containsKey(squarenum)){
                        if (squares.get(squarenum).contains(num)){
                            return 0;
                        }
                        squares.get(squarenum).add(num);
                    }else{
                        HashSet<Integer> nums = new HashSet<>();
                        nums.add(num);
                        squares.put(squarenum,nums);
                    }
                }
            }
        }

        return 1;
    }

}
