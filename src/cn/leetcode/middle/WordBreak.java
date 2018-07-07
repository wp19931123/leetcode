package cn.leetcode.middle;

import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 */
public class WordBreak {

    /**
     * 动态规划
     * 用dp[i]表示0到i的子字符串是否可以拆分成满足条件的单词
     * 如果以i为结尾的j~i子串是满足条件的，并且0~j的子串也是在字典中的，那么dp[i]就是true。
     * 用公式表示就是：
     * dp[i+1] = dp[j] && s.substring[j,i+1]∈dict
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null) {
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 0;i < len;i++) {
            StringBuilder sb = new StringBuilder(s.substring(0,i+1));
            for(int j = 0;j <= i;j++) {
                if(dp[j] && wordDict.contains(sb.toString())) {
                    dp[i+1] = true;
                    break;
                }
                sb.deleteCharAt(0);
            }
        }

        return dp[len];
    }

}
