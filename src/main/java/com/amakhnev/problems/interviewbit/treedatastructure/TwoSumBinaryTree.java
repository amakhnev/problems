package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.Arrays;
import java.util.Stack;

public class TwoSumBinaryTree {


    public static void main(String[] args) {

        TreeNode input = TreeNode.createTree(Arrays.asList(6, 4, 8, 2, 5, 7, 9, 1, 3, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1));
        TreePrinter.print(input);

        System.out.println(new TwoSumBinaryTree().t2Sum(input, 19));
    }

    public int t2Sum(TreeNode A, int B) {

        Stack<TreeNode> leftNodes = new Stack<>(), rightNodes = new Stack<>();
        TreeNode curr = A;
        while (curr != null) {
            leftNodes.push(curr);
            curr = curr.left;
        }
        curr = A;
        while (curr != null) {
            rightNodes.push(curr);
            curr = curr.right;
        }

        TreeNode left = leftNodes.pop(), right = rightNodes.pop();
        while (left.val < right.val) {


            if (left.val + right.val > B) { // move right node
                if (right.left != null) {
                    curr = right.left;
                    while (curr != null) {
                        rightNodes.push(curr);
                        curr = curr.right;
                    }
                }
                right = rightNodes.pop();

            } else if (left.val + right.val < B) { // move left node
                if (left.right != null) {
                    curr = left.right;
                    while (curr != null) {
                        leftNodes.push(curr);
                        curr = curr.left;
                    }
                }
                left = leftNodes.pop();

            } else {
                return 1;
            }


        }
        return 0;

    }

}
