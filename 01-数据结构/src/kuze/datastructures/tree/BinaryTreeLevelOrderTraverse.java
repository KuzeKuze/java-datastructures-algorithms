package kuze.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraverse {

    public static void traverse(BinaryTreeNode root){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if( root != null ) queue.offer(root);
        while( !queue.isEmpty() ){
            BinaryTreeNode p = queue.poll();
            System.out.print(p.val + " ");
            if( p.left != null ) queue.offer(p.left);
            if( p.right != null ) queue.offer(p.right);
        }
    }
}
