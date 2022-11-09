package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.Arrays;

public class InvertTheBinaryTree {


    public static void main(String[] args) {
        TreeNode input = TreeNode.createTree(Arrays.asList(6, 4, 8, 2, 5, 7, 9, 1, 3, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1));
        TreePrinter.print(input);
        TreePrinter.print(new InvertTheBinaryTree().invertTree(input));

    }

    public TreeNode invertTree(TreeNode A) {
        if (A == null) {
            return null;
        }
        TreeNode temp = A.left;
        A.left = invertTree(A.right);
        A.right = invertTree(temp);
        return A;
    }
}
