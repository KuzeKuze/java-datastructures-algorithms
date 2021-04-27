package kuze.datastructures.tree;

import java.util.Stack;

public class BinaryTreePostOrderTraverse {

    public static void traverse(BinaryTreeNode root){
        if(root != null){
            traverse(root.left);
            traverse(root.right);
            System.out.println(root.val + " ");
        }
    }

    /**
     * 采用双栈法进行后序遍历
     *      观察可以发现，后序遍历是 根-右-左 这种镜像前序遍历顺序的 逆序
     *      stack1用于进行 根-右-左的遍历
     *      stack2用于逆序
     */
    public static void traverseByStack(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        if( root != null ) stack1.push(root);

        while(!stack1.empty()){
            BinaryTreeNode p = stack1.pop();
            stack2.push(p);
            if( p.left != null ) stack1.push(p.right);
            if( p.right != null) stack1.push(p.left);
        }
        while(!stack2.empty()){
            BinaryTreeNode p = stack2.pop();
            System.out.println(p.val + " ");
        }
    }
}
