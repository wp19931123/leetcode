package cn.leetcode.middle;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));  //bab
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));  //bb
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chs = manacher(s);  //去除奇偶性在字符的间隙添加#字符
        int[] pArr = new int[chs.length]; //存放第i个位置的回文半径值
        int C = -1;   //回文中心
        int R = -1;   //回文串到达的最右边界
        int max = Integer.MIN_VALUE;  //保存最长回文长度
        String res = "";
        for (int i = 0; i < chs.length; i++) {
            pArr[i] = i < R ? Math.min(pArr[2 * C - i], R - i) : 1; //遍历到的位置在R内
            while (i + pArr[i] < chs.length && i - pArr[i] >= 0) {  //暴力两边扩
                if (chs[i + pArr[i]] == chs[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {  //更新回文半径和右边界
                R = i + pArr[i];
                C = i;
            }
            if(pArr[i] > max) {
                max = pArr[i];
                res = s.substring(C - max/2, C + max/2);
            }
        }
        return res;
    }

    private char[] manacher(String s) {
        char[] chs = s.toCharArray();
        char[] res = new char[2 * chs.length + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chs[index++];

        }
        return res;
    }
}
