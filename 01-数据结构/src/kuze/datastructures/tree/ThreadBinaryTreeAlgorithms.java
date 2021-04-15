package kuze.datastructures.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 线索二叉树的相关算法:
 *      1）线索二叉树有如下规定：
 *          若结点有左子树，则其left指向左孩子，否则令left指向其前驱结点
 *          若结点有右子树，则其right指向右孩子，否则令right指向其后继结点
 *
 *      2）指向结点前驱和后继的指针，叫做线索
 *
 *      3）对二叉树以某种次序遍历使其变为线索二叉树的过程叫做线索化
 *
 *      4）线索化的过程即为在遍历的过程中修改空指针的过程
 *
 *      5）leftTag为true表示left指向了前驱，为false表示指向左孩子
 *
 *      6）rightTag为true表示right指向了后继，为false表示指向右孩子
 */
public class ThreadBinaryTreeAlgorithms {

    /**
     * 二叉树线索化的函数
     */
    public static ThreadNode pre = null;

    /**
     * 先序-线索化
     */
    public static void preThread(ThreadNode root){
        if(root != null){

            /**
             * ===================线索化开始========================
             */
            if(pre != null){
                if( pre.getRight() == null){ // 若上一个结点的右子树空
                    pre.setRight(root);
                    pre.setRightTag(true);
                }else{
                    pre.setRightTag(false);
                }
            }
            if(root.getLeft() == null){ // 若当前节点左子树空
                root.setLeft(pre);
                root.setLeftTag(true);
            }else {
                root.setLeftTag(false);
            }
            pre = root;

            /**
             * ===================线索化结束========================
             */
            if( root.isLeftTag() == false){
                preThread(root.getLeft());
            }
            preThread(root.getRight());
        }
    }

    /**
     * 中序-线索化
     */

    public static void inThread(ThreadNode root){
        if( root != null){
            inThread(root.getLeft());

            /**
             * ===================线索化开始========================
             */
            if(pre != null){
                if( pre.getRight() == null){ // 若上一个结点的右子树空
                    pre.setRight(root);
                    pre.setRightTag(true);
                }else{
                    pre.setRightTag(false);
                }
            }
            if(root.getLeft() == null){ // 若当前节点左子树空
                root.setLeft(pre);
                root.setLeftTag(true);
            }else {
                root.setLeftTag(false);
            }
            pre = root;
            /**
             * ===================线索化结束========================
             */

            inThread(root.getRight());
        }
    }

    /**
     * 后序-线索化
     */

    public static void postThread(ThreadNode root){
        if(root != null){
            postThread(root.getLeft());
            postThread(root.getRight());
            /**
             * ===================线索化开始========================
             */
            if(pre != null){
                if( pre.getRight() == null){ // 若上一个结点的右子树空
                    pre.setRight(root);
                    pre.setRightTag(true);
                }else{
                    pre.setRightTag(false);
                }
            }
            if(root.getLeft() == null){ // 若当前节点左子树空
                root.setLeft(pre);
                root.setLeftTag(true);
            }else {
                root.setLeftTag(false);
            }
            pre = root;
            /**
             * ===================线索化结束========================
             */
        }
    }

    public static void levelorderByQueue(ThreadNode root){
        Queue<ThreadNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }

        while(!queue.isEmpty()){
            ThreadNode p = queue.poll();
            System.out.println(p + " ");
            if(p.getLeft() != null && p.isLeftTag() == false){
                queue.offer(p.getLeft());
            }
            if(p.getRight() != null && p.isRightTag() == false){
                queue.offer(p.getRight());
            }
        }
    }

    /**
     * 带头结点的线索化
     *      头结点left指向 树的根节点，leftTag==false，若树空，则left悬空
     *      头结点right指向 遍历访问的最后一个节点，rightTag==true，若树空，则right指向自己
     *      遍历的第一个节点的 left指向 头结点
     *      遍历的最后一个节点的right指向头结点
     */

    /**
     * 带头结点的先序线索化
     */
    public static ThreadNode preThreadWithHead(ThreadNode root){
        ThreadNode head = new ThreadNode("head");

        // 线索化
        pre = head;
        preThread(root);
        // 线索化完成
        pre.setRight(head);
        head.setLeft(root);
        head.setLeftTag(false);
        head.setRight(pre);
        head.setRightTag(true);

        return head;
    }

    public static ThreadNode inThreadWithHead(ThreadNode root){
        ThreadNode head = new ThreadNode("head");

        // 线索化
        pre = head;
        inThread(root);
        // 线索化完成
        pre.setRight(head);
        head.setLeft(root);
        head.setLeftTag(false);
        head.setRight(pre);
        head.setRightTag(true);

        return head;
    }

    public static ThreadNode postThreadWithHead(ThreadNode root){
        ThreadNode head = new ThreadNode("head");

        // 线索化
        pre = head;
        postThread(root);
        // 线索化完成
        pre.setRight(head);
        head.setLeft(root);
        head.setLeftTag(false);
        head.setRight(pre);
        head.setRightTag(true);

        return head;
    }
    /**
     * 遍历线索二叉树的算法：
     *      1、先序遍历
     *          1）查找节点的前驱：
     *              * leftTag == true  -----> leftTag指向为前驱结点
     *              * leftTag == false，左子树存在
     *                  - 节点为双亲节点的左子树  ----> 前驱为双亲节点
     *                  - 节点为双亲节点的右子树  ----> 前驱双亲节点的左子树的最后遍历的节点（在双亲节点的左子树一直往右走，没有右就左走）
     *
     *          2）查找节点的后继：
     *              * rightTag == true -----> rightTag指向后继结点
     *              * rightTag == false，右子树存在
     *                  - 节点存在左子树，则为左子树根
     *                  - 若不存在左子树，则为右子树根（右子树一定存在，因为rightTag==false）
     *
     *      2、中序遍历
     *          1）查找节点前驱：
     *              * leftTag == true  -----> leftTag指向为前驱结点
     *              * leftTag == false，左子树存在
     *                  - 则是遍历左子树时最后一个访问的节点（在左子树上一直往右走，直到节点没有右孩子）
     *
     *          2）查找节点后继：
     *              * rightTag == true -----> rightTag指向后继结点
     *              * rightTag == false，右子树存在
     *                  - 则是遍历右子树时第一个访问的节点（在右子树一直向左走，直到没有左孩子，也就是leftTag==1的节点）
     *
     *      3、后序遍历
     *          1）查找节点前驱：
     *              * leftTag == true  -----> leftTag指向为前驱结点
     *              * leftTag == false，左子树存在
     *                  - 若此时右子树存在，则是右子树的根
     *                  - 若右子树不存在，则是其左子树的根
     *
     *          2）查找节点后继
     *              * rightTag == true -----> rightTag指向后继结点
     *              * rightTag == false，右子树存在，后序一定是最后访问根节点
     *                  - 若结点是根节点，那么没有后继
     *                  - 若结点是双亲节点的右孩子，那么双亲节点为后继
     *                  - 若结点是双亲节点的左孩子，
     *                      若双亲有右孩子，即节点有右兄弟，那么后继为右兄弟的第一个访问的元素（右兄弟的一直往左走，除非某一节点没有左孩子，就往右走）
     *                      若双亲节点没有右孩子，后继为双亲节点
     *
     */

    public static void traverseInThread(ThreadNode head){
        ThreadNode p = head.getLeft();
        while( p != null){
            while( p.isLeftTag() == false ) p = p.getLeft();
            System.out.println(p);
            while(p.isRightTag() == true && p.getRight() != head){
                p = p.getRight();
                System.out.println(p);
            }
            p = p.getRight();
        }
    }

    public static void main(String[] args) {

//        // 空树
//        ThreadNode root1 = null;
//        pre = null;
//        preThread(root1);
//        levelorderByQueue(root1);
//
//        pre = null;
//        inThread(root1);
//        levelorderByQueue(root1);
//
//        pre = null;
//        postThread(root1);
//        levelorderByQueue(root1);

//        // 只有一个节点的树
//        ThreadNode root2 = new ThreadNode("One");
//        pre = null;
//        preThread(root2);
//        levelorderByQueue(root2);

//        pre = null;
//        inThread(root2);
////        levelorderByQueue(root2);
//
//        pre = null;
//        postThread(root2);
////        levelorderByQueue(root2);



        ThreadNode node1 = new ThreadNode("1");
        ThreadNode node2 = new ThreadNode("2");
        ThreadNode node3 = new ThreadNode("3");
        ThreadNode node4 = new ThreadNode("4");
        ThreadNode node5 = new ThreadNode("5");
        ThreadNode node6 = new ThreadNode("6");
        node1.setLeft(node3);
        node1.setRight(node2);
        node3.setLeft(node5);
        node3.setRight(node4);
        node2.setRight(node6);

        // 左右子树都有的树
        ThreadNode root3 = node1;

//        pre = null;
//        preThread(root3);
//        levelorderByQueue(root3);

//        pre = null;
//        inThread(root3);
//        levelorderByQueue(root3);

        pre = null;
        postThread(root3);
        levelorderByQueue(root3);


        // 只有左子树



    }
}
