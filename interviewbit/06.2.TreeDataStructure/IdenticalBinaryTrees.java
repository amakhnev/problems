import java.util.Arrays;

public class IdenticalBinaryTrees {

    public static void main(String[] args) {
        TreeNode node1 = TreeNode.createTree(Arrays.asList(1,2,3,-1,-1,-1,-1));
        TreeNode node2 = TreeNode.createTree(Arrays.asList(1,3,3,-1,-1,-1,-1));
        System.out.println(new IdenticalBinaryTrees().isSameTree(node1,node2));
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        if ((A==null && B==null)){
            return 1;
        }
        if (A!=null && B!=null && A.val==B.val){

            if (isSameTree(A.left,B.left)==0){
                return 0;
            }
            return isSameTree(A.right,B.right);
        }
        return 0;
    }

}
