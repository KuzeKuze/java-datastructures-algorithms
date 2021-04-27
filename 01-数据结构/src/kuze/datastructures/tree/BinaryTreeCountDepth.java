package kuze.datastructures.tree;

public class BinaryTreeCountDepth {
    public static int count(BinaryTreeNode root){
        if( root == null ) return 0;
        int leftDepth = count(root.left);
        int rightDepth = count(root.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }
}