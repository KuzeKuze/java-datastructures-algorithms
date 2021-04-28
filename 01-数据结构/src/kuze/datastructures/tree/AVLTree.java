package kuze.datastructures.tree;
import kuze.datastructures.tree.BinaryTreeNode;
public class AVLTree {

    public static void main(String[] args) {
        BinaryTreeNode root = null;
        root = insert(root, 1);
        root = insert(root, 2);
        root = insert(root, 3);
        root = insert(root, 4);
        root = insert(root, 5);
        root = insert(root, 6);
        root = insert(root, 7);
        BinaryTreePreOrderTraverse.traverse(root);
        System.out.println();
        BinaryTreeInOrderTraverse.traverse(root);
        System.out.println();
        BinaryTreeLevelOrderTraverse.traverse(root);

    }
    public static BinaryTreeNode insert(BinaryTreeNode root, int val){
        if( root == null ) return new BinaryTreeNode(val);
        if(val < root.val){
            root.left = insert(root.left, val);

            // 插入到左子树上且造成不平衡
            if( getHeight(root.left) - getHeight(root.right) > 1){
                // 左子树的左子树上, 左单旋
                if( val < root.left.val){
                    root = leftRotate(root);
                }
                // 左子树的右子树上，左右双旋
                else if( val > root.left.val ){
                    root.left = rightRotate(root.left);
                    root = leftRotate(root);
                }
            }

        } else {
            root.right = insert(root.right, val);

            // 插入到右子树上且造成不平衡
            if( getHeight(root.left) - getHeight(root.right) < -1){
                // 右子树的右子树上
                if( val >= root.right.val){
                    root = rightRotate(root);
                }
                // 右子树的左子树上，右左双旋
                else if( val < root.right.val){
                    root.right = leftRotate(root.right);
                    root = rightRotate(root);
                }
            }
        }
        return root;
    }


    // 左单旋
    private static BinaryTreeNode leftRotate(BinaryTreeNode root){
        if( root == null || root.left == null) return root;
        BinaryTreeNode newRoot = root.left;
        BinaryTreeNode oldRoot = root;
        oldRoot.left = newRoot.right;
        newRoot.right = oldRoot;
        return newRoot;
    }

    // 右单旋
    private static BinaryTreeNode rightRotate(BinaryTreeNode root){
        if( root == null || root.right == null) return root;
        BinaryTreeNode newRoot = root.right;
        BinaryTreeNode oldRoot = root;
        oldRoot.right = newRoot.left;
        newRoot.left = oldRoot;
        return newRoot;
    }

    // 计算树高
    public static int getHeight(BinaryTreeNode root){
        if( root != null ){
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
        }
        return  0;
    }
}
