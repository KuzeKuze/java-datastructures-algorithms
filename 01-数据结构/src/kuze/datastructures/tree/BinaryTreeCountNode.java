package kuze.datastructures.tree;


/**
 * 计算节点个数
 */
public class BinaryTreeCountNode {
    public static int count(BinaryTreeNode root){
        if( root == null ) return 0;
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }
}
