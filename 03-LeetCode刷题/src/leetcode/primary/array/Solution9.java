package leetcode.primary.array;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 */
public class Solution9 {
    public int[] twoSum(int[] nums, int target) {

        /**
         * 注意存在负数的情况
         */
        for(int i = 0; i < nums.length-1; i++){

            for(int j = i+1; j<nums.length; j++){

                if( nums[i] + nums[j] == target){
                    return  new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        Solution9 solution9 = new Solution9();
        int[] reuslts = solution9.twoSum(nums, target);
        System.out.println(reuslts[0] + " " + reuslts[1]);
    }
}
