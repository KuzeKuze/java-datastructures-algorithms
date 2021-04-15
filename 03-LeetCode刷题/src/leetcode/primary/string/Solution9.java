package leetcode.primary.string;

public class Solution9 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        for(String str : strs){
            if(str.length() == 0) return "";
        }

        int numPrefix = 0;

        String first = strs[0];
        for(int i = 0; i < first.length(); i++){
            char ch = first.charAt(i);
            int index = i;
            boolean isSame = true;
            for(String str:strs){
                if( index < str.length() ){
                    if( str.charAt(index) != ch){
                        isSame = false;
                         break;
                    }
                } else {
                    isSame = false;
                    break;
                }
            }
            if(isSame){
                numPrefix++;
            } else {
                break;
            }

        }
        return first.substring(0, numPrefix);
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        for(String str : strs){
            if(str.length() == 0) return "";
        }

        String first = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(first) != 0){
                first = first.substring(0, first.length()-1);
            }
            i++;
        }
        return first;
    }

    public static void main(String[] args) {
        String[] strs = {};
        Solution9 solution9 = new Solution9();
        String result = solution9.longestCommonPrefix2(strs);
        System.out.println(result);
    }
}
