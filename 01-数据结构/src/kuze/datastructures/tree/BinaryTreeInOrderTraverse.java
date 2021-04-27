package kuze.datastructures.tree;

import java.util.Stack;

public class BinaryTreeInOrderTraverse {

    public static void traverse(BinaryTreeNode root){
        if(root != null){
            traverse(root.left);
            System.out.println(root.val + " ");
            traverse(root.right);
        }
    }

    public static void traverseByStack(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode p = root;
        while( !stack.empty() || p != null){
            while( p != null ){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p.val + " ");
            p = p.right;
        }
    }
}
