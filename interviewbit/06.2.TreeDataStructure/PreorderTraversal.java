import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PreorderTraversal {


    public static void main(String[] args) {
        TreeNode input = TreeNode.createTree(Arrays.asList(460, 3871, 4698, 8399, 504, 4421, 7515, -1, 4167, 5727, -1, -1, 3096, 434, 7389, 2667, 5661, 1969, 7815, 4292, 3006, 9750, 6693, -1, 6906, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1));
        System.out.println(new PreorderTraversal().preorderTraversal(input));
        TreePrinter.print(input);
    }

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = A;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                result.add(current.val);
                stack.push(current);
                current = current.left;

            } else {
                current = stack.pop().right;
            }
        }
        return result;
    }
}
