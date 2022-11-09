package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.Arrays;
import java.util.HashMap;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode input = TreeNode.createTree(Arrays.asList(17,28,44,48,-1,12,58,7,6,23,64,20,37,45,26,36,18,27,-1,-1,46,54,-1,56,14,-1,-1,47,50,67,-1,2,35,-1,-1,60,41,-1,-1,10,24,-1,63,61,40,-1,-1,4,59,1,-1,29,-1,52,9,21,15,33,-1,-1,-1,55,-1,-1,-1,-1,11,38,32,-1,-1,-1,49,8,-1,51,57,13,22,62,-1,53,42,-1,25,-1,-1,43,34,-1,-1,-1,-1,-1,-1,31,39,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,30,-1,-1,-1,-1,5,-1,66,-1,19,-1,-1,65,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1));
        System.out.println(new BalancedBinaryTree().isBalanced(input));

    }

    public int isBalanced(TreeNode A) {
        HashMap<TreeNode,Integer> heights = new HashMap<>();
        loadHeigth(heights,A);
        return isBalanced(heights,A);
    }

    private int isBalanced(HashMap<TreeNode, Integer> heights, TreeNode a) {
        if (a==null){
            return 1;
        }
        if (isBalanced(heights,a.left)==0 || isBalanced(heights,a.right)==0){
            return 0;
        }

        return Math.abs((a.left==null?0:heights.get(a.left))-(a.right==null?0:heights.get(a.right)))<2?1:0;

    }

    public int loadHeigth(HashMap<TreeNode,Integer> heights,TreeNode A){
        if (A==null){
            return 0;
        }
        int height = 1+Math.max(loadHeigth(heights,A.left),loadHeigth(heights,A.right));
        heights.put(A,height);
        return height;
    }
}
