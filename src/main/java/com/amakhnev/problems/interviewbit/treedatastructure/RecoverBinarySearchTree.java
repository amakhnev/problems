package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;

public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode input = TreeNode.createTree(Arrays.asList(6, 3, 8, 2, 5, 7, 9, 1, 4, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1));
        TreePrinter.print(input);
        ArrayList<Integer> result = new RecoverBinarySearchTree().recoverTree(input);
        for (int num : result) {
            System.out.print(num + " ");
        }

    }

    TreeNode first, second, third, prev;

    public ArrayList<Integer> recoverTree(TreeNode A) {

        first = second = third = prev = null;

        traverseNode(A);
        ArrayList<Integer> result = new ArrayList<>();

        if (first != null && third != null) {
            result.add(third.val);
            result.add(first.val);
        } else if (first != null && second != null) // no third node means two adjusted nodes were swapped
        {
            result.add(second.val);
            result.add(first.val);
        }
        return result;
    }

    public void traverseNode(TreeNode curr) {
        if (curr == null) {
            return;
        }

        // traverse left subtree
        traverseNode(curr.left);
        // if incorrect node found
        if (prev != null && curr.val < prev.val) {
            //  On first occurrence these two nodes are "first" and "second"
            if (first == null) {
                first = prev;
                second = curr;
            }
            //  On second occurrence current node is "third"
            else
                third = curr;
        }
        prev = curr;

        // traverse right subtree
        traverseNode(curr.right);
    }
}
