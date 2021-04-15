package leetcode.primary.array;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int income = 0;

        for(int i = 0; i < prices.length - 1 ; i++){
            if(prices[i] < prices[i+1]){
                int j = i+1;
                for( ; j < prices.length - 1; j++){
                    if(prices[j] >prices[j+1]){
                        break;
                    }
                }
                income += prices[j] - prices[i];
                i = j;
            }
        }
        return income;
    }
    public int maxProfit2(int[] prices) {
        int income = 0;
        for(int i = 0; i<prices.length-1; i++){
            if(prices[i] < prices[i+1]){
                income += prices[i+1] - prices[i];
            }
        }
        return  income;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int[] prices = {7,1,5,3,6,4};
        System.out.println(solution2.maxProfit2(prices));
    }
}
