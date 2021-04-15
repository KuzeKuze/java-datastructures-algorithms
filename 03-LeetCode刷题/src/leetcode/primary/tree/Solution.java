package leetcode.primary.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {

    public int maxDepth(TreeNode root) {
        if(root != null){
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
        }else {
            return 0;
        }


    }
}
