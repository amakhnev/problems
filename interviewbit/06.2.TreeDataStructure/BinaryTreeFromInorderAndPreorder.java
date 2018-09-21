import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreeFromInorderAndPreorder {


    public static void main(String[] args) {
        TreePrinter.print(new BinaryTreeFromInorderAndPreorder().buildTree(
                new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(2, 1, 3))
        ));
    }


    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() <= 1) {
            return A.size() == 1 ? new TreeNode(A.get(0)) : null;
        }

        TreeNode top = new TreeNode(A.get(0));
        int idxB = B.indexOf(top.val);
        top.left = buildTree(new ArrayList(A.subList(1, idxB + 1)), new ArrayList(B.subList(0, idxB)));
        top.right = buildTree(new ArrayList(A.subList(idxB + 1, A.size())), new ArrayList(B.subList(idxB + 1, B.size())));
        return top;
    }
}
