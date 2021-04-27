package kuze.datastructures.tree;

public class BinaryTreeCountZeroDegreeNode {
    public static int countZeroDegreeNode(BinaryTreeNode root){
        if( root == null ) return 0;
        if( root.left == null && root.right == null ) return 1;
        int leftCount = countZeroDegreeNode(root.left);
        int rightCount= countZeroDegreeNode(root.right);
        return leftCount + rightCount;
    }
}
