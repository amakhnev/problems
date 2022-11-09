package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.ArrayList;
import java.util.Collections;

public class ZigZagLevelOrderTraversalBt {

    public static void main(String[] args) {
        TreeNode input = TreeNode.createTree(3, 9, 20, -1, -1, 15, 7, -1, -1, -1, -1);
        TreePrinter.print(input);
        ArrayList<ArrayList<Integer>> output = new ZigZagLevelOrderTraversalBt().zigzagLevelOrder(input);
        System.out.println(output);

        for (ArrayList<Integer> level : output) {
            for (int num : level) {
            }
        }
    }


    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<TreeNode> levels = new ArrayList<>();
        levels.add(A);
        boolean isLeft2Right = true;
        while (!levels.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            ArrayList<TreeNode> newLevels = new ArrayList<>();
            for (TreeNode node : levels) {
                level.add(node.val);
                if (isLeft2Right) {
                    if (node.left != null)
                        newLevels.add(node.left);
                    if (node.right != null)
                        newLevels.add(node.right);
                } else {
                    if (node.right != null)
                        newLevels.add(node.right);
                    if (node.left != null)
                        newLevels.add(node.left);
                }
            }
            result.add(level);
            Collections.reverse(newLevels);
            levels = newLevels;
            isLeft2Right = !isLeft2Right;
        }


        return result;
    }

}
