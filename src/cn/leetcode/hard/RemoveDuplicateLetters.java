package cn.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 示例 1:
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 */
public class RemoveDuplicateLetters {
    /**
     * 先用哈希表记录每个字母出现的次数，再遍历给定字符串s，找出最小的字母，
     * 每比较一个字母，在哈希表中的值减1，如果此时为0了，则不继续遍历了，
     * 此时我们记录了一个位置，把字符串s中该位置左边的字符都删掉，右边的所有再出现的该字母也删掉，递归调用此函数
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        //记录字符出现次数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        removeDuplicateLetters(s, map);

        return "";
    }

    private String res = "";

    private void removeDuplicateLetters(String s, Map<Character, Integer> map) {
        if (s == null || s.length() == 0) {
            return;
        }
        for (int i = 1; i < s.length(); i++) {
            char pre = s.charAt(i - 1);
            if (map.get(pre) < 1) {
                res += pre;
                continue;
            }
            map.put(pre, map.get(pre) - 1);
        }
    }
}
