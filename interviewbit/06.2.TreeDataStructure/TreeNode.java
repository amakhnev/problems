import java.util.LinkedList;
import java.util.List;

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
