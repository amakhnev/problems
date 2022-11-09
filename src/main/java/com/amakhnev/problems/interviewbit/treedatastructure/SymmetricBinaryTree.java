package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.Arrays;

public class SymmetricBinaryTree {

    public static void main(String[] args) {
        TreeNode node = TreeNode.createTree(Arrays.asList(1, 2, 2, -1, -1, -1, -1));
        System.out.println(new SymmetricBinaryTree().isSymmetric(node));
    }

    public int isSymmetric(TreeNode A) {
        return isSameTree(A.left, mirror(A.right));
    }

    private TreeNode mirror(TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode newNode = new TreeNode(node.val);
        newNode.left = mirror(node.right);
        newNode.right = mirror(node.left);
        return newNode;
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        if ((A == null && B == null)) {
            return 1;
        }
        if (A != null && B != null && A.val == B.val) {
            if (isSameTree(A.left, B.left) == 0) {
                return 0;
            }
            return isSameTree(A.right, B.right);
        }
        return 0;
    }
}
