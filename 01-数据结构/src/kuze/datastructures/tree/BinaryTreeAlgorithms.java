package kuze.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树相关算法
 */
public class BinaryTreeAlgorithms {

    /**
     * 递归-二叉树的先序遍历
     */
    public static void preorderByRecursion(Node root){
        if(root != null){
            System.out.print(root + " ");
            preorderByRecursion(root.getLeft());
            preorderByRecursion(root.getRight());
        }
    }

    /**
     * 递归-二叉树的中序遍历
     */
    public static void inorderByRecursion(Node root){
        if(root != null){
            inorderByRecursion(root.getLeft());
            System.out.print(root + " ");
            inorderByRecursion(root.getRight());
        }
    }

    /**
     * 递归-二叉树的后序遍历
     */
    public static void postorderByRecursion(Node root){
        if(root != null){
            postorderByRecursion(root.getLeft());
            postorderByRecursion(root.getRight());
            System.out.print(root + " ");
        }
    }


    /**
     * 栈-二叉树的先序遍历
     */
    public static void preorderByStack(Node root){
        Stack<Node> stack = new Stack<>();
        if(root != null){
            stack.push(root);
        }
        while (!stack.empty()){
            Node p = stack.pop();
            System.out.print(p + " ");
            if( p.getRight() != null){
                stack.push(p.getRight());
            }
            if( p.getLeft() != null){
                stack.push(p.getLeft());
            }
        }
    }

    /**
     * 栈-二叉树的中序遍历
     */
    public static void inorderByStack(Node root){
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while(p != null || !stack.empty()){
            if( p != null){
                stack.push(p);
                p = p.getLeft();
            }else {
                if(!stack.empty()){
                    p = stack.pop();
                    System.out.print(p + " ");
                    p = p.getRight();
                }
            }
        }
    }

    /**
     * 栈-二叉树的后序遍历
     */
    public static void postorderByStack(Node root){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        if(root != null){
            stack1.push(root);
        }

        while(!stack1.empty()){
            Node p = stack1.pop();
            stack2.push(p);
            if(p.getLeft() != null){
                stack1.push(p.getLeft());
            }
            if(p.getRight() != null){
                stack1.push(p.getRight());
            }
        }

        while(!stack2.empty()){
            Node p = stack2.pop();
            System.out.print(p + " ");
        }
    }

    /**
     * 队列-层序遍历
     */

    public static void levelorderByQueue(Node root){
        Queue<Node> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }

        while(!queue.isEmpty()){
            Node p = queue.poll();
            System.out.print(p + " ");
            if(p.getLeft() != null){
                queue.offer(p.getLeft());
            }
            if(p.getRight() != null){
                queue.offer(p.getRight());
            }
        }
    }


    /**
     * 拷贝树
     */
    public static Node copyTree(Node root){
        if(root == null) return null;
        Node newRoot = new Node(root.getId());
        newRoot.setRight(copyTree(root.getRight()));
        newRoot.setLeft(copyTree(root.getLeft()));
        return newRoot;
    }

    /**
     * 计算树深度
     */
    public static int getDepth(Node root){
        if(root == null) return 0;
        int rightDepth = getDepth(root.getRight());
        int leftDepth = getDepth(root.getLeft());
        return (rightDepth > leftDepth ? rightDepth : leftDepth) + 1;
    }

    // 注意，以下的算法，计算节点个数，或者是计算度为0/1/2的节点数，层序遍历都可以实现
    // 但是为了扩展思维这里用了递归的方法
    // 有时间实现吧
    /**
     * 计算节点个数
     */
    public static int getNodeNum(Node root){
        if(root == null) return 0;
        int leftNodeNum = getNodeNum(root.getLeft());
        int rightNodeNum = getNodeNum(root.getRight());
        return leftNodeNum + rightNodeNum + 1;
    }

    /**
     * 计算度为0的节点个数
     */
    public static int getZeroDegreeNodeNum(Node root){
        if(root == null) return 0;

        int leftZeroDegreeNodeNum = getZeroDegreeNodeNum(root.getLeft());
        int rightZeroDegreeNodeNum = getZeroDegreeNodeNum(root.getRight());
        if(root.getLeft() == null && root.getRight() == null){
            return 1;
        }else {
            return leftZeroDegreeNodeNum + rightZeroDegreeNodeNum;
        }

    }
    /**
     * 计算度为1的节点个数
     */
    public static int getOneDegreeNodeNum(Node root){
        if(root == null) return 0;

        int leftOneDegreeNodeNum = getOneDegreeNodeNum(root.getLeft());
        int rightOneDegreeNodeNum = getOneDegreeNodeNum(root.getRight());
        if((root.getRight() != null && root.getLeft() == null) || (root.getRight() == null && root.getLeft() != null)){
            return leftOneDegreeNodeNum + rightOneDegreeNodeNum + 1;
        }else {
            return leftOneDegreeNodeNum + rightOneDegreeNodeNum;
        }
    }

    /**
     * 计算度为2的节点个数
     */
    public static int getTwoDegreeNodeNum(Node root){
        if(root == null) return 0;

        int leftTwoDegreeNodeNum = getTwoDegreeNodeNum(root.getLeft());
        int rightTwoDegreeNodeNum = getTwoDegreeNodeNum(root.getRight());
        if( root.getLeft() != null && root.getRight() != null){
            return leftTwoDegreeNodeNum+rightTwoDegreeNodeNum + 1;
        }else {
            return  leftTwoDegreeNodeNum+rightTwoDegreeNodeNum;
        }
    }

    public static void main(String[] args) {
        Node root = new Node("1");
        root.setLeft(new Node("3"));
        root.setRight(new Node("2"));
        root.getLeft().setLeft(new Node("5"));
        root.getRight().setRight(new Node("7"));
        root.getLeft().setRight(new Node("4"));



        System.out.println(getZeroDegreeNodeNum(root));
        System.out.println(getOneDegreeNodeNum(root));
        System.out.println(getTwoDegreeNodeNum(root));
    }
}
