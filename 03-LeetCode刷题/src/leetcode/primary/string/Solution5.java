package leetcode.primary.string;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 */
public class Solution5 {
    public boolean isPalindrome(String s) {
        if("".equals(s)) return true;

        s = s.toLowerCase();
        char[] sequence = s.toCharArray();
        int N = sequence.length;
        int i=0,j=N -1;

        while(i < j){
            while(i < N){
                if( ('a' <= sequence[i]  && sequence[i] <= 'z') || ('0' <= sequence[i]  && sequence[i] <= '9')){
                    break;
                } else {
                    i++;
                }
            }
            while(j > 0){
                if( ('a' <= sequence[j]  && sequence[j] <= 'z')|| ('0' <= sequence[j]  && sequence[j] <= '9')){
                    break;
                } else {
                    j--;
                }
            }

            if(i < j && sequence[i] != sequence[j]){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "AP";
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.isPalindrome(s));

    }
}
