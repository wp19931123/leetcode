package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
    //"dvdf"
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int begin = 0;
        int max = 0;
        for(int i = 0;i < s.length();i++) {
            if(list.contains(s.charAt(i))) {
                list = new ArrayList<>();
                if(i - begin > max) {
                    max = i - begin;
                }
                i = begin + 1;
                begin = i;
                list.add(s.charAt(i));
            }else{
                list.add(s.charAt(i));
                if(i == s.length()-1) {
                    if(i - begin + 1 > max) {
                        max = i - begin + 1;
                    }
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;

        if (s == null || s.length() == 0) {
            return maxLength;
        }

        int startIndex = 0;
        int endIndex = 0;

        int length = s.length();
        Set<Character> set = new HashSet<>();
        while (startIndex < length && endIndex < length && startIndex <= endIndex) {
            char c = s.charAt(endIndex);
            if (!set.contains(c)) {
                set.add(c);
                endIndex++;
            } else {
                if (endIndex - startIndex > maxLength) {
                    maxLength = endIndex - startIndex;
                }
                set.remove(s.charAt(startIndex));
                startIndex++;
            }
        }
        if (endIndex - startIndex > maxLength) {
            maxLength = endIndex - startIndex;
        }
        return maxLength;
    }
}
