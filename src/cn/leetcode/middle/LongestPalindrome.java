package cn.leetcode.middle;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        

        return null;
    }

    public boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length()-1;
        while(l < r) {
            if(str.charAt(l) != str.charAt(r)) {
                return  false;
            }
            l++;
            r--;
        }
        return true;
    }
}
