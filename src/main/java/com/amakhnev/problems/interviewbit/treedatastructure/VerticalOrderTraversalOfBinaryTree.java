package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(new VerticalOrderTraversalOfBinaryTree().verticalOrderTraversal(
                TreeNode.createTree(Arrays.asList(460, 3871, 4698, 8399, 504, 4421, 7515, -1, 4167, 5727, -1, -1, 3096, 434, 7389, 2667, 5661, 1969, 7815, 4292, 3006, 9750, 6693, -1, 6906, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1))
        ));
    }


    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) {
            return result;
        }

        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> lines = new TreeMap<>();
        traverse(lines, 0, 0, A);

        for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> line : lines.entrySet()) {
            ArrayList<Integer> values = new ArrayList<>();
            for (Map.Entry<Integer, ArrayList<Integer>> value : line.getValue().entrySet()) {
                values.addAll(value.getValue());
            }
            result.add(values);
        }

        return result;
    }

    public void traverse(TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> results, int currLine, int currLevel, TreeNode node) {
        if (!results.containsKey(currLine)) {
            results.put(currLine, new TreeMap<>());
        }
        if (!results.get(currLine).containsKey(currLevel)) {
            results.get(currLine).put(currLevel, new ArrayList<>());
        }
        results.get(currLine).get(currLevel).add(node.val);
        if (node.left != null) {
            traverse(results, currLine - 1, currLevel + 1, node.left);
        }
        if (node.right != null) {
            traverse(results, currLine + 1, currLevel + 1, node.right);
        }
    }
}
