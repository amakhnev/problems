package com.amakhnev.problems.interviewbit.treedatastructure;

public class TreeLinkNode extends TreeNode implements TreePrinter.PrintableNode {

    TreeLinkNode next;
    TreeLinkNode left;
    TreeLinkNode right;

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return right;
    }


    TreeLinkNode(int x) {
        super(x);
        next = null;
    }


    public static TreeLinkNode convert(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeLinkNode result = new TreeLinkNode(node.val);
        result.left = convert(node.left);
        result.right = convert(node.right);
        return result;
    }
}
