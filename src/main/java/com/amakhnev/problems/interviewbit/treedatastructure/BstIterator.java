package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.Arrays;
import java.util.Stack;

public class BstIterator {


    public static void main(String[] args) {
        TreeNode input = TreeNode.createTree(Arrays.asList(6, 4, 8, 2, 5, 7, 9, 1, 3, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1));

        Solution i = new BstIterator().new Solution(input);
        while (i.hasNext()) System.out.print(i.next());
    }

    public class Solution {

        Stack<TreeNode> nodes = new Stack<>();
        TreeNode current = null;

        public Solution(TreeNode root) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }
            if (!nodes.isEmpty()) {
                current = nodes.pop();
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            int result = current.val;
            if (current.right != null) {
                TreeNode temp = current.right;
                while (temp != null) {
                    nodes.push(temp);
                    temp = temp.left;
                }
            }

            if (!nodes.isEmpty()) {
                current = nodes.pop();
            } else {
                current = null;
            }

            return result;
        }
    }

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */

}
