package leetcode.primary.array;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 */
public class Solution3 {
    int tmp = 0;
    public void rotate(int[] nums, int k) {
        if(k % nums.length == 0) return;
        k = k % nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);


    }

    public void reverse(int nums[], int start, int end){
        int i = start;
        int j = end;
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        Solution3 solution3 = new Solution3();
        solution3.rotate(nums, k);
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
