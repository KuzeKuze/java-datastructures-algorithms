package leetcode.primary.tree;

import java.util.Arrays;

public class Solution5 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        if(nums.length == 1) return new TreeNode(nums[0]);


        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);

        int[] leftNodes = Arrays.copyOfRange(nums, 0, mid);
        int[] rightNodes = Arrays.copyOfRange(nums, mid+1, nums.length);

        TreeNode left = sortedArrayToBST(leftNodes);
        TreeNode right = sortedArrayToBST(rightNodes);
        root.left = left;
        root.right = right;
        return root;

    }
}
