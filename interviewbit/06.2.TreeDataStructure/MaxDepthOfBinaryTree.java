import java.util.Arrays;

public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode input = TreeNode.createTree(Arrays.asList(6, 4, 8, 2, 5, 7, 9, 1, 3, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1));

        System.out.println(new MaxDepthOfBinaryTree().maxDepth(input));

    }

    public int maxDepth(TreeNode A) {

        return Math.max(A.left != null ? maxDepth((A.left)) : 0, A.right != null ? maxDepth((A.right)) : 0) + 1;

    }
}
