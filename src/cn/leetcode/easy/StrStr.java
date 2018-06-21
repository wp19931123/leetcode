package cn.leetcode.easy;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * 当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(new StrStr().strStr(haystack,needle));
    }

    public int strStr(String haystack, String needle) {
        if(haystack == null || haystack == null) {
            return -1;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2 == 0) {
            return 0;
        }
        for(int i = 0;i <= len1-len2;i++) {
            for(int j = 0;j < len2;j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if(j == len2-1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
