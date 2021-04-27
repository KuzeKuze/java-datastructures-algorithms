package kuze.datastructures.tree;

public class BinaryTreeCountOneDegreeNode {
    public static int count(BinaryTreeNode root){
        if( root == null ) return 0;
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + ( isOneDegreeNode(root) ? 1 : 0 );
    }

    public static boolean isOneDegreeNode(BinaryTreeNode root){
        return (root.right != null && root.left == null) || (root.right == null && root.left != null);
    }
}
