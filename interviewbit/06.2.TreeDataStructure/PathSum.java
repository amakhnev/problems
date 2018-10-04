public class PathSum {

    public static void main(String[] args) {
        TreeNode input = TreeNode.createTree(5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1);
        TreePrinter.print(input);
        System.out.println(new PathSum().hasPathSum(input, 18));
    }

    public int hasPathSum(TreeNode A, int B) {
        if (A.left == null && A.right == null) { //leaf
            return A.val - B == 0 ? 1 : 0;
        }
        if (A.left != null) {
            if (hasPathSum(A.left, B - A.val) == 1) {
                return 1;
            }
        }
        if (A.right != null) {
            if (hasPathSum(A.right, B - A.val) == 1) {
                return 1;
            }
        }
        return 0;
    }
}
