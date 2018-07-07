package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PartitionHuiWen {

    List<List<String>> results;
    boolean[][] isPalindrome;

    public List<List<String>> partition(String s) {
        results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }

        getIsPalindrome(s);

        helper(s, 0, new ArrayList<>());

        return results;
    }

    //动态规划
    //isPalindrome[i][j] = isPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j)
    //自然如果一个串是回文串，那么首尾必须要相等，并且中间也是子串。
    //初始化，显然当i==j的时候都是回文串
    //当串只有两个字符且相等的时候也是回文串。
    private void getIsPalindrome(String s) {
        int n = s.length();
        isPalindrome = new boolean[n][n];
        for(int i = 0;i < n;i++) {
            isPalindrome[i][i] = true;
        }
        for(int i = 0;i < n-1;i++) {
            isPalindrome[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }
        for(int i = n-3;i >= 0;i--) {
            for(int j = i+2;j < n;j++) {
                isPalindrome[i][j] = (isPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j));
            }
        }
    }

    //深度搜索和回溯法
    private void helper(String s, int start, ArrayList<Integer> partition) {
        if (start == s.length()) {
            addResult(s, partition);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome[start][i]) {
                continue;
            }
            partition.add(i);
            helper(s, i + 1, partition);
            partition.remove(partition.size() - 1);
        }
    }

    private void addResult(String s, ArrayList<Integer> partition) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < partition.size(); i++) {
            result.add(s.substring(startIndex, partition.get(i) + 1));
            startIndex = partition.get(i) + 1;
        }
        results.add(result);
    }
}
