package leetcode.primary.array;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 */
public class Solution7 {

    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        boolean isCarry = false;
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 10){
                break;
            }else{
                digits[i] = digits[i] % 10;
                if( i != 0){
                    digits[i-1] += 1;
                } else {
                    isCarry = true;
                }
            }
        }
        if(!isCarry){
            return digits;
        }else{
            int[] results = new int[digits.length + 1];
            results[0] = 1;
            for(int i = 1 ; i <results.length; i++){
                results[i] = digits[i-1];
            }
            return results;
        }

    }

    public static void main(String[] args) {
        int[] digits = {0};
        Solution7 solution7 = new Solution7();
        int[] results = solution7.plusOne(digits);
        for(int i : results){
            System.out.println(i);
        }
    }
}
