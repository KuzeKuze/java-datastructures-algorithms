package leetcode.primary.string;

import java.util.Arrays;

public class Solution4 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        int[] nums1 = new int[26];
        int[] nums2 = new int[26];

        for(int i = 0; i < str1.length; i++){
            nums1[str1[i] - 'a']++;
            nums2[str2[i] - 'a']++;
        }

        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] != nums2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort((str1));
        Arrays.sort((str2));
        return Arrays.equals(str1, str2);
    }

    /**
     * 这是最快的解法
     */
    public boolean isAnagram3(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        int[] mapS = new int[26];
        for(int i = 0; i < str1.length; i++){
            mapS[str1[i] - 'a']++;
            mapS[str2[i] - 'a']--;
        }

        for(int i = 0; i < mapS.length; i++){
            if(mapS[i] != 0){
                return  false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        Solution4 solution4 = new Solution4();

        System.out.println(solution4.isAnagram3(s,t));

    }
}
