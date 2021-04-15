package leetcode.primary.array;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int i = 0, lastNum=-1000000;
        int len = 0;
        for(int j=0; j<nums.length; j++){
            if( nums[j] != lastNum){
                lastNum = nums[j];
                nums[i] = nums[j];
                i++;
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = solution.removeDuplicates(nums);
        for(int i:nums){
            System.out.println(i);
        }
        System.out.println("len="+len);
    }
}
