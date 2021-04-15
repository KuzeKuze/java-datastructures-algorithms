package leetcode.primary.dp;

public class Solution1 {
    public static int nums = 0;
    public int climbStairs(int n) {
        if( n == 0) return nums;

        if(climbOne(n) == 0) nums++;
        if(climbTow(n) == 0) nums++;


    }



    public int climbOne(int target){
        return target - 1;
    }

    public int climbTow(int target){
        return target - 2;
    }

}
