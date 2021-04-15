package leetcode.primary.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 */
public class Solution4 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(new Solution4().containsDuplicate(nums));
    }
}
