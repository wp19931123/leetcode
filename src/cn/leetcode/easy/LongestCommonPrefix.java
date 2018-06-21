package cn.leetcode.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Note : All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"a"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs[0] == null || strs[0].length() == 0) {
            return "";
        }
        int minLen = strs[0].length();
        //求最短长度
        for(int i = 0; i < strs.length; i++) {
            if(strs[i] == null || strs[i].length() == 0) {
                return "";
            }
            if(strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }
        int longgest = 0;
        for(int i = 0;i < minLen;i++) {
            for(int j = 0;j < strs.length;j++) {
               if(strs[0].charAt(i) != strs[j].charAt(i)) {
                   return longgest > 0 ? strs[0].substring(0,longgest) : "";
               }
           }
           longgest++;
        }
        return strs[0].substring(0,longgest);
    }
}
