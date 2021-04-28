package kuze.datastructures.tree;

import java.util.Stack;

public class BinaryTreePreOrderTraverse {

    public static void traverse(BinaryTreeNode root){
        if(root != null){
            System.out.print(root.val + " ");
            traverse(root.left);
            traverse(root.right);
        }
    }

    public static void traverseByStack(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack = new Stack<>();

        if( root != null ) stack.push(root);

        while(!stack.empty()){
            BinaryTreeNode p = stack.pop();
            System.out.print(p.val + " ");
            if( p.right != null ) stack.push(p.right);
            if( p.left != null ) stack.push(p.left);
        }
    }
}
