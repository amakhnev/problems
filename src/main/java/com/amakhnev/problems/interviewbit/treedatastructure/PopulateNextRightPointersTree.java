package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.ArrayList;

public class PopulateNextRightPointersTree {

    public static void main(String[] args) {
        TreeLinkNode node = TreeLinkNode.convert(TreeNode.createTree(1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1));

        TreePrinter.print(node);

        new PopulateNextRightPointersTree().connect(node);

        TreePrinter.print(node);

    }


    public void connect(TreeLinkNode root) {
        ArrayList<TreeLinkNode> level = new ArrayList<>();
        level.add(root);

        while (!level.isEmpty()) {
            ArrayList<TreeLinkNode> newLevel = new ArrayList<>();
            for (int i = 0; i < level.size(); i++) {
                TreeLinkNode current = level.get(i);
                if (i != level.size() - 1) {
                    current.next = level.get(i + 1);
                }
                if (current.left != null) {
                    newLevel.add(current.left);
                }
                if (current.right != null) {
                    newLevel.add(current.right);
                }
            }
            level = newLevel;
        }

    }

}
