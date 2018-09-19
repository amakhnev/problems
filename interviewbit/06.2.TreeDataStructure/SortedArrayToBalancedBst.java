import java.util.Arrays;
import java.util.List;

public class SortedArrayToBalancedBst {

    public static void main(String[] args) {

        TreePrinter.print(new SortedArrayToBalancedBst().sortedArrayToBST(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
        ));

    }


    public TreeNode sortedArrayToBST(final List<Integer> a) {
        if (a.size() <= 1) {
            return a.size() == 1 ? new TreeNode(a.get(0)) : null;
        }

        int mid = a.size() / 2;
        TreeNode node = new TreeNode(a.get(mid));
        node.left = sortedArrayToBST(a.subList(0, mid));
        node.right = sortedArrayToBST(a.subList(mid + 1, a.size()));

        return node;
    }


}
