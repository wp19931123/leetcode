package cn.leetcode.hard;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数。
 * 输入: "aab"
 * 输出: 1
 */
public class MinCut {

    public static void main(String[] args) {
        System.out.print(new MinCut().minCut("aabc"));
    }
    /**
     * 动态规划
     * dp[i] - 表示子串（0，i）的最小回文切割，则最优解在dp[s.length-1]中。
     * 1.初始化：当字串s.substring(0,i+1)(包括i位置的字符)是回文时，dp[i] = 0(表示不需要分割)；否则，dp[i] = i（表示至多分割i次）;
     * 2.对于任意大于1的i，如果s.substring(j,i+1)(j<=i,即遍历i之前的每个子串)是回文时，dp[i] = min(dp[i], dp[j-1]+1);
     * 3.如果s.substring(j,i+1)(j<=i)不是回文时，dp[i] = min(dp[i],dp[j-1]+i+1-j);
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                dp[i] = 0;
            } else {
                dp[i] = i;
            }
            for (int j = 1; j <= i; j++) {
                if (isPalindrome(s.substring(j, i + 1))) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                } else {
                    dp[i] = Math.min(dp[i], dp[j - 1] + i - j + 1);
                }
            }
        }
        return dp[len-1];
    }

    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
