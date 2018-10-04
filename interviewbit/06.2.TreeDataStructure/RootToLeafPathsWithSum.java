import java.util.ArrayList;

public class RootToLeafPathsWithSum {

    public static void main(String[] args) {
        TreeNode input = TreeNode.createTree(5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1, -1, -1, -1, -1, -1, -1, -1, -1);
        TreePrinter.print(input);
        System.out.println(new RootToLeafPathsWithSum().pathSum(input, 22));
    }


    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        pathSum(A, B, results, new ArrayList<>());
        return results;
    }

    public void pathSum(TreeNode A, int B, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> path) {
        path.add(A.val);
        if (A.left == null && A.right == null) {
            if (A.val - B == 0) {
                results.add(path);
            }
            return;
        }
        if (A.left != null) {
            pathSum(A.left, B - A.val, results, A.right == null ? path : new ArrayList(path));
        }
        if (A.right != null) {
            pathSum(A.right, B - A.val, results, path);
        }
    }

}
