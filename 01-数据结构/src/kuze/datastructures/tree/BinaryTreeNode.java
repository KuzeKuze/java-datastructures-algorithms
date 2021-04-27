package kuze.datastructures.tree;

public class BinaryTreeNode {
    public Integer val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int val){
        this.val = val;
    }

    public BinaryTreeNode(){

    }


    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "val=" + val +
                ", left=" + (left != null ? left.val : null) +
                ", right=" + (right != null ? right.val : null) +
                '}';
    }
}
