package leetcode.primary.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<Integer> list;

    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        inTraverse(root);
        for(int i = 0 ; i < list.size() -1; i++){
            if( list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;

    }

    public void inTraverse(TreeNode root){
        if(root != null){
            inTraverse(root.left);
            list.add(root.val);
            inTraverse(root.right);
        }

    }

    /**
     * 解法2，递归
     */
    public boolean isValidBST2(TreeNode root) {
       return isValidBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST2(TreeNode root, long minVal, long maxVal){
        if(root == null) return true;

        if( root.val <= minVal || root.val >= maxVal) return false;

        boolean isLeft = isValidBST2(root.left, minVal, root.val);
        boolean isRight = isValidBST2(root.right, root.val, maxVal);
        if( isLeft && isRight ) return true;
        else return  false;
    }
}
