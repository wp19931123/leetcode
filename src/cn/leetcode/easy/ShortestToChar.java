package cn.leetcode.easy;

/**
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class ShortestToChar {

    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        for(int i = 0;i < S.length();i++) {
            res[i] = getShortest(S,i,C);
        }
        return res;
    }

    public int getShortest(String s,int i,char c) {
        if(s.charAt(i) == c) {
            return 0;
        }
        int left = i-1;
        int right = i+1;
        while(true) {
            if(left >= 0) {
                if(s.charAt(left) == c) {
                    return i - left;
                }else{
                    left--;
                }
            }
            if(right < s.length()) {
                if(s.charAt(right) == c) {
                    return right - i;
                }else{
                    right++;
                }
            }
        }
    }
}
