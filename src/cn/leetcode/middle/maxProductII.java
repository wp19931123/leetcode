package cn.leetcode.middle;

import java.util.Arrays;

/**
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
 * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 */
public class maxProductII {

    public static void main(String[] args) {
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println(new maxProductII().maxProduct(words));
    }

    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }
        int n = words.length;
        int res = 0;
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!hasCommon(words[i], words[j])) {
                    int tmp = words[i].length() * words[j].length();
                    res = tmp > res ? tmp : res;
                }
            }
        }
        return res;
    }

    //确定两个字符串是否含有公共字符
    private boolean hasCommon(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) == a.charAt(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    //32位的 int 值足够用每一位表示26位字母是否在单词中出现。
    // 假设字母 a 可以映射为第0位，b可以映射为第1位，...，z 可以映射为第25位
    public int maxProduct2(String[] words) {
        int len = words.length;
        int[] table = new int[len];  //table[i]用于存储 words[i] 中存现哪些小写字母
        int maxLen = 0;  //记录最大长度
        for (int i = 0; i < len; i++)
            for (int j = 0; j < words[i].length(); j++)
                table[i] |= 1 << words[i].charAt(j) - 'a';  //将出现的字母映射到 int 相应的那一位，并将那一位置为1
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++)
                if ((table[i] & table[j]) == 0)  //①
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
        return maxLen;
    }
}
