package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.Arrays;
import java.util.Stack;

public class KthSmallestElementInTree {


    public static void main(String[] args) {

        TreeNode input = TreeNode.createTree(Arrays.asList(6, 4, 8, 2, 5, 7, 9, 1, 3, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1));
        TreePrinter.print(input);

        System.out.println(new KthSmallestElementInTree().kthsmallest(input, 10));
    }


    public int kthsmallest(TreeNode A, int B) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = A;
        int count = 0, max = 0;
        while (!stack.empty() || current != null) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.empty()) {
                current = stack.pop();
                max = current.val;
                if (B - ++count == 0) {
                    return current.val;
                }
                current = current.right;
            }
        }
        // if number of nodes < B
        return max;
    }

}
