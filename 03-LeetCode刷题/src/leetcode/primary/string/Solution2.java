package leetcode.primary.string;

public class Solution2 {
    public int reverse(int x) {
        long num = (long) x;
        boolean flag;

        if( num < 0) flag = false;
        else flag = true;

        num = Math.abs(num);
        long reverse_num = 0;
        while( num != 0){
            long re = num % 10;
            reverse_num = reverse_num * 10 + re;
            num /= 10;
        }
        if(!flag) reverse_num = - reverse_num;
        if( reverse_num < Integer.MIN_VALUE || reverse_num > Integer.MAX_VALUE){
            return 0;
        }else {
            return (int) reverse_num;
        }
    }

    public int reverse2(int x) {
        if(x == 0) return 0;
        if(x == Integer.MIN_VALUE) return 0;

        int reverseNum = 0;
        boolean flag = x >= 0 ? true : false;
        x = Math.abs(x);

        while( x != 0 ){
            int re = x % 10;
            x /= 10;
            int originNum = reverseNum;
            reverseNum =  reverseNum * 10 + re;

            // 判定是否溢出
            if( (reverseNum - re) / 10 != originNum){
                return 0;
            }
        }
        if(!flag) return -reverseNum;
        return reverseNum;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.reverse(1516000009));
    }
}
