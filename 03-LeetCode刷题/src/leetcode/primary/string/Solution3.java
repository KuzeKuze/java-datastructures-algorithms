package leetcode.primary.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 */
public class Solution3 {
    public int firstUniqChar(String s) {
        char input[] = s.toCharArray();
        Map map = new HashMap();

        for(char c : input){
            if(map.containsKey(c)){
                Integer num = (Integer) map.get(c);
                num++;
                map.put(c, num);
            } else {
                map.put(c, 1);
            }
        }

        for(int i = 0;  i < input.length; i++){
            if(map.containsKey(input[i])){
                if((Integer)map.get(input[i]) == 1){
                    return i;
                }
            }
        }
        return -1;
    }
    public int firstUniqChar2(String s) {
        char input[] = s.toCharArray();
        int occurenceTimes[] = new int[26];

        for(char c : input){
            occurenceTimes[c - 'a']++;
        }
        for(int i = 0; i < input.length; i++){
            if(occurenceTimes[input[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int pos = solution3.firstUniqChar2( "leetcode");
        System.out.println(pos);
    }
}
