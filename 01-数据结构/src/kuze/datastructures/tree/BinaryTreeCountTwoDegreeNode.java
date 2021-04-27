package kuze.datastructures.tree;

public class BinaryTreeCountTwoDegreeNode {

    public static int count(BinaryTreeNode root){
        if(root == null ) return 0;
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + (isTwoDegreeNode(root) ? 1 : 0);
    }

    public static boolean isTwoDegreeNode(BinaryTreeNode root){
        return root.left != null && root.right != null;
    }
}
