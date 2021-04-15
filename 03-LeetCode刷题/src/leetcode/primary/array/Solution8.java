package leetcode.primary.array;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 */
public class Solution8 {
    public void moveZeroes(int[] nums) {
        int numZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                numZero ++;
            }
        }

        if(numZero == 0) {
            return;
        }

        int j = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        for(int i = nums.length - numZero; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        Solution8 solution8 = new Solution8();
        solution8.moveZeroes(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }
}
