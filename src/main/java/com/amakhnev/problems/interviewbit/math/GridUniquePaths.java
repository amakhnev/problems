package com.amakhnev.problems.interviewbit.math;

public class GridUniquePaths {

    public static void main(String[] args) {
        System.out.println("Result = " + new GridUniquePaths().uniquePaths(15,9));
    }


    public int uniquePaths(int A, int B) {
        if (A<=0 || B<=0){
            return 0;
        }
        if (A==1 || B==1){
            return 1;
        }

        int[][] paths = new int[A][B];
        //first row
        for (int i = 0; i < A; i++){
            paths[i][0] = 1;
        }

        //first column
        for (int j = 0; j < B; j++){
            paths[0][j] = 1;
        }

        // for each next number of paths = num of paths coming from left + and from top
        for (int i = 1; i < A; i++)
        {
            for (int j = 1; j < B; j++)

                paths[i][j] = paths[i-1][j] + paths[i][j-1];

        }
        return paths[A-1][B-1];
    }

}
