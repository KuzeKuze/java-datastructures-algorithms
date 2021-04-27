package kuze.datastructures.tree;

public class BinaryTreeCopy {
    public static BinaryTreeNode copy(BinaryTreeNode root){
        if( root == null ) return null;
        BinaryTreeNode newRoot = new BinaryTreeNode();
        newRoot.val = root.val;
        newRoot.left = copy(root.left);
        newRoot.right= copy(root.right);

        return newRoot;
    }
}
