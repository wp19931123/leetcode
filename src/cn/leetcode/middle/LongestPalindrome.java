package cn.leetcode.middle;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String res = null;
        int max = 0;
        for(int i = 0;i < s.length();i++) {

        }

        return res;
    }

//    public String getPalindrome(String s,int i) {
//        int l = i-1;
//        int r = i+1;
//        while(l >= 0 && r < s.length()) {
//            if(s.charAt(l) != s.charAt(r)) {
//                return s.substring(l+1,r-1);
//            }
//            l++;
//            r--;
//        }
//        return s;
//    }

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
