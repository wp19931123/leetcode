package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 所有输入均为小写字母。
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new GroupAnagrams().groupAnagrams(arr);
        System.out.println(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null) {
            return res;
        }
        int length = strs.length;
        boolean[] flag = new boolean[length];
        for(int i = 0;i < length;i++) {
            if(flag[i]) {
                continue;
            }
            List<String> tmp = new ArrayList<>();
            tmp.add(strs[i]);
            flag[i] = true;
            for(int j = i+1;j < length;j++) {
                if(flag[j]) {
                    continue;
                }
                if(isAnagram(strs[i],strs[j])) {
                    tmp.add(strs[j]);
                    flag[j] = true;
                }
            }
            res.add(tmp);
        }

        return res;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
