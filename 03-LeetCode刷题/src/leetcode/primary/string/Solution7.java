package leetcode.primary.string;

public class Solution7 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "";
        Solution7 solution7 = new Solution7();
        int ans = solution7.strStr(haystack, needle);
        System.out.println(ans);
    }
}
