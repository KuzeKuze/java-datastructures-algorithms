package leetcode.primary.tree;

// https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
public class Solution3 {

    public boolean isSymmetric(TreeNode root) {
       return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode left, TreeNode right){
        if( left == null && right == null ) return true;

        if( left == null || right == null || left.val != right.val){
            return false;
        }
        if( isSame(left.left, right.right) && isSame(left.right, right.left) ){
            return true;
        }else {
            return false;
        }

    }


}
