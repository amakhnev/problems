package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.*;

public class TreeNode implements TreePrinter.PrintableNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        return "" + val;
    }

    public static String getCustomInputString(TreeNode node) {
        return getCustomInputString(node, " ", true);
    }

    public static String getCustomInputString(TreeNode node, String separator, boolean addCount) {
        List<Integer> output = getCustomInput(node);
        StringBuilder sb = new StringBuilder();
        if (addCount) {
            sb.append(output.size());
            sb.append(separator);
        }

        for (int i = 0; i < output.size(); i++) {
            sb.append(output.get(i));
            if (i < output.size() - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    public static List<Integer> getCustomInput(TreeNode node) {
        List<Integer> output = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            output.add(curr.val);
            if (curr.val > 0) {
                queue.offer(curr.left != null ? curr.left : new TreeNode(-1));
                queue.offer(curr.right != null ? curr.right : new TreeNode(-1));
            }
        }

        return output;
    }

    public static TreeNode createTree(Integer... nums) {
        return createTree(Arrays.asList(nums));
    }

    public static TreeNode createTree(List<Integer> input) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(input.get(0));
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                continue;
            }
            if (input.get(i) >= 0) {
                curr.left = new TreeNode(input.get(i));
                queue.offer(curr.left);
            } else {
                curr.left = null;
                queue.offer(null);
            }
            i++;


            if (input.get(i) >= 0) {
                curr.right = new TreeNode(input.get(i));
                queue.offer(curr.right);
            } else {
                curr.right = null;
                queue.offer(null);
            }
            i++;
        }
        return root;
    }
}
