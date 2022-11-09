package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {
        TreePrinter.print(new BinaryTreeFromInorderAndPostorder().buildTree(
                new ArrayList<>(Arrays.asList(10, 20, 30, 40)),
                new ArrayList<>(Arrays.asList(40, 30, 20, 10))
        ));
    }


    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (B.size() <= 1) {
            return B.size() == 1 ? new TreeNode(B.get(0)) : null;
        }

        TreeNode top = new TreeNode(B.get(B.size() - 1));
        int idxA = A.indexOf(top.val);
        top.left = buildTree(new ArrayList(A.subList(0, idxA)), new ArrayList(B.subList(0, idxA)));
        top.right = buildTree(new ArrayList(A.subList(idxA + 1, A.size())), new ArrayList(B.subList(idxA, B.size() - 1)));
        return top;
    }

}
