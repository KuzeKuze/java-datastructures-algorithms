package leetcode.primary.array;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 */
public class Solution5 {
    //异或运算满足交换律

    /**
     * a ^ a = 0
     * 0 ^ a = a
     * a^b^a =  a^a^b = 0 ^ b = b
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int reduce = 0;
        for(int num:nums){
            reduce ^= num;
        }
        return reduce;
    }
}
