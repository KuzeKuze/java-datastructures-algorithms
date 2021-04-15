package leetcode.primary.string;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 */
public class Solution {
    public void reverseString(char[] s) {
        for(int i = 0;  i < s.length / 2; i ++){
            char tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        Solution solution = new Solution();
        solution.reverseString(s);
        for(char t : s){
            System.out.print(t);
        }
    }
}
